/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTests;

import Drivers.instDrivers;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import logicadigital.viagensonlineteste.DaPontuacaoDestinoPage;
import net.bytebuddy.asm.Advice;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Armando
 */
@RunWith(Parameterized.class)
public class PontuacaoDestinosTest {
    
    DaPontuacaoDestinoPage dp;
    boolean output;
    static int resetUrl=0;
    
    @BeforeClass
    public static void setUpClass() {
        instDrivers.setUrl("http://192.168.56.175:8080/TP-warWebSite/faces/vistas/pontuacao/pontDest.xhtml");
        resetUrl=1;
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
        
    }
    
    public PontuacaoDestinosTest(String pontBil, boolean out) {
        this.dp=new DaPontuacaoDestinoPage();
        this.dp.setPontDestino(pontBil);
        this.output=out;
    }
    
    @Parameterized.Parameters
    public static Collection insercaoDadosParametrizaveis() {
        return Arrays.asList(new Object[][]{
            {"5",true},
            {"-8", false},
            {"12", false}
        });
    }
    
    public void registaForm() {

        try {

            /*OBTENCAO INSTANCIA DA WEBDRIVER*/
            WebDriver w = instDrivers.getInstanceDriver();
            
            /*OBTENCAO DAS PONTUACOES*/
            List<WebElement> radiosDest=w.findElements(By.xpath("//*[contains(@id, 'j_idt81:rate:')]"));
            
            int indice=0;/*SE APENAS FOR UM VAI SER CLICADO O UNICO ELEMENTO RADIO BUTTON, COM A POSICAO 0*/
            if(radiosDest.size()>1){
                Random random = new Random();
                indice = random.nextInt(radiosDest.size());
            }
            
            /*CLICK DO RADIO BUTTON ESCOLHIDO*/
            radiosDest.get(indice).click();
            Thread.sleep(1000);
            this.dp.setNomeDestino(radiosDest.get(indice).getAttribute("value"));
            
            /*COLOCACAO DA PONTUACAO A SER DADA AO DESTINO, NA CAIXA DE INPUT*/
            WebElement caixa=w.findElement(By.name("j_idt81:j_idt84"));
            if(caixa!=null){
                caixa.clear();/*APAGA O SEU CONTEUDO, CASO TENHA*/
                Thread.sleep(1000);
                caixa.sendKeys(this.dp.getPontDestino());
            }
            
            /*CLICK BOTAO SUMBETER PONTUACAO*/
            WebElement linkSubmeter=w.findElement(By.linkText("Submeter Pontuacao"));
            
            if(linkSubmeter!=null){
                Thread.sleep(1000);
                linkSubmeter.click();
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

    }
    
    @Test
    public void testaPont(){
        
        try{
            
            if(resetUrl>1){
                instDrivers.setUrl("http://192.168.56.175:8080/TP-warWebSite/faces/vistas/pontuacao/pontDest.xhtml");
            }
            
            /*CHAMADA PARA O MÉTODO DE REGISTO DOS VALORES NA FORM*/
            this.registaForm();
            resetUrl++;
            /*VERIFICACAO SE CORREU BEM OU MAL*/
            if(instDrivers.getInstanceDriver().getCurrentUrl().equals("http://192.168.56.175:8080/TP-warWebSite/faces/PontSucesso.xhtml")==true && this.output==true){
                assertTrue("Inserida pontuacao", true);
            }
            else if(instDrivers.getInstanceDriver().getCurrentUrl().equals("http://192.168.56.175:8080/TP-warWebSite/faces/vistas/pontuacao/pontDest.xhtml")==true && this.output==false){
                assertTrue("Mostrado valor invalido com exito", true);
            }
            else{
                assertFalse("Problema", true);
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        
    }
    
}
