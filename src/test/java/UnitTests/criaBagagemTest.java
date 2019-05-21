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
import logicadigital.viagensonlineteste.CriaBagagemPage;
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
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Armando
 */
@RunWith(Parameterized.class)
public class criaBagagemTest {
    
    /*VARIAVEIS*/
    CriaBagagemPage cbp;
    boolean otput;
    
    @BeforeClass
    public static void setUpClass() {
        instDrivers.setUrl("http://192.168.56.175:8080/TP-warWebSite/faces/vistas/bagagens/insereBagagens.xhtml");
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
    
    public criaBagagemTest(int peso, boolean outEsp) {
        this.cbp=new CriaBagagemPage(peso);
        this.otput=outEsp;
    }
    
    public void resetURL() throws InterruptedException{
        Thread.sleep(1000);
        instDrivers.setUrl("http://192.168.56.175:8080/TP-warWebSite/faces/vistas/bagagens/insereBagagens.xhtml");
    }
    
    @Parameterized.Parameters
    public static Collection insercaoDadosParametrizaveis() {
        return Arrays.asList(new Object[][]{
            {2,true},
            {-10, false}
        });
    }
    
    public int getRandomIndex(int dropSize){
        
        try {

            Random random = new Random();
            return random.nextInt(dropSize);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }
    
    public boolean selectOptionDrop(WebDriver w, String idDrop){
        
        try{
            
            /*DROPDOWN 1 E 2--> ID DO CLIENTE OU ID DAS VIAGENS, CLICK AUTOMATICO DE UM DOS SEUS VALORES*/
            /*OBTENCAO DA LISTA DE IDS DE CLIENTES OU VIAGENS, INSERIDOS NA DROPDOWN*/
            Select dropCliOptions = new Select(w.findElement(By.id(idDrop)));
            List<WebElement> allOptionsDropCli = dropCliOptions.getOptions();

            int indice = 0;
            if (allOptionsDropCli.size() > 1) {
                indice = this.getRandomIndex(allOptionsDropCli.size());
            }
            /*CLICK DA OPCAO DA DROPDOWN SELECCIONADA*/
            allOptionsDropCli.get(indice).click();
            
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public void registaForm(WebDriver w){
        
        try{
            
            /*COLOCAR NA CAIXA DE TEXTO, O VALOR DO PESO*/
            Thread.sleep(2000);
            WebElement caixaTexto= w.findElement(By.id("j_idt73:pesoBagagens"));
            caixaTexto.clear();/*LIMPAR O SEU CONTEUDO*/
            /*ENVIO DO PESO DEFINIDO NOS TESTES PARAMETRIZAVEIS*/
            String convertPeso=Integer.toString(this.cbp.getPesoBagagem());
            caixaTexto.sendKeys(convertPeso);
            Thread.sleep(1000);
            
            /*DROPDOWN 1*/
            this.selectOptionDrop(w, "j_idt73:idCliente");
            Thread.sleep(1000);
            
            /*DROPDOWN 2*/
            this.selectOptionDrop(w, "j_idt73:idViagens");
            Thread.sleep(1000);
            
            /*CLICK SAVE (COMMAND LINK)*/
            WebElement linkSave=w.findElement(By.linkText("Save"));
            linkSave.click();
            Thread.sleep(1000);
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
        
    }
    
    @Test
    public void testBagagem(){
        
        try{
            
            /*OBTENCAO DA INSTANCIA DA DRIVER*/
            WebDriver webDriv=instDrivers.getInstanceDriver();
            
            if(webDriv.getCurrentUrl().equals("http://192.168.56.175:8080/TP-warWebSite/faces/vistas/bagagens/insereBagagens.xhtml")==false){
                instDrivers.setUrl("http://192.168.56.175:8080/TP-warWebSite/faces/vistas/bagagens/insereBagagens.xhtml");
            }
            
            /*REGISTO DA FORM DA PÁGINA*/
            this.registaForm(webDriv);
            
            /*VALIDACAO DOS TESTES*/
            if(webDriv.getCurrentUrl().equals("http://192.168.56.175:8080/TP-warWebSite/faces/vistas/bagagens/infoTodasBagagens.xhtml")==true && this.otput==true){
                assertTrue("Inserida Bagagem com Sucesso", true);
            }
            else if(webDriv.getCurrentUrl().equals("http://192.168.56.175:8080/TP-warWebSite/faces/erro.xhtml")==true && this.otput==false){
                assertTrue("Erro mostrado com sucesso", true);
            }
            else{
                assertFalse("Problema", true);
            }
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
