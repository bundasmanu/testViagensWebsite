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
import logicadigital.viagensonlineteste.CompraBilhetesPage;
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
public class CompraBilhetesTest {
   
    private CompraBilhetesPage bp;
    private boolean output;
    
    @BeforeClass
    public static void setUpClass() {
        instDrivers.setUrl("http://192.168.56.175:8080/TP-warWebSite/faces/vistas/bilhete/CompraBilhetes.xhtml");
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
    
    public CompraBilhetesTest(String numBil, boolean out) {
        this.bp=new CompraBilhetesPage();
        this.bp.setNumBilhetes(numBil);
        this.output=out;
    }
    
    @Parameterized.Parameters
    public static Collection insercaoDadosParametrizaveis() {
        return Arrays.asList(new Object[][]{
            {"2",true},
            {"-10", false}
        });
    }
    
    public void registaForm(WebDriver x) throws InterruptedException {
        /*MEDIANTE O NUMERO DE RADIO BUTTONS, ESCOLHE RANDOM UMA VIAGEM*/
        Thread.sleep(2000);
        List<WebElement> options = x.findElements(By.xpath("//*[contains(@id, 'j_idt72:rate:')]"));
        Random random = new Random();
        int indice = random.nextInt(options.size());
        options.get(indice).click();
        Thread.sleep(1000);
        bp.setIdViagem((options.get(indice).getAttribute("value")));
        /*CAIXA DE TEXTO COLOCA LÁ O SEU VALOR*/
        WebElement txt=x.findElement(By.id("j_idt72:txtNumeroBilhetes"));
        txt.clear();
        txt.sendKeys(this.bp.getNumBilhetes());
        Thread.sleep(1000);
    }
    
    @Test
    public void testaCompraBilhetes() throws InterruptedException{
        WebDriver web=instDrivers.getInstanceDriver();
        instDrivers.setUrl("http://192.168.56.175:8080/TP-warWebSite/faces/vistas/bilhete/CompraBilhetes.xhtml");
        this.registaForm(web);
        web.findElement(By.id("j_idt72:btnConfirmar")).click();
        if(web.getCurrentUrl().equals("http://192.168.56.175:8080/TP-warWebSite/faces/index.xhtml")==true && this.output==true){
            assertTrue("Compra com exito",true);
        }
        else if(web.getCurrentUrl().equals("http://192.168.56.175:8080/TP-warWebSite/faces/erro.xhtml")==true && this.output==false){
            assertTrue("Redirreciona erro com exito",true);
        }
        else{
            assertFalse("Problema", true);
        }
    }
    
}
