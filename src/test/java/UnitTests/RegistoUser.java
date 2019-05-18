/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTests;

import Drivers.instDrivers;
import java.util.Arrays;
import java.util.Collection;
import logicadigital.viagensonlineteste.RegisterPage;
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

/**
 *
 * @author Armando
 */
@RunWith(Parameterized.class)
public class RegistoUser {
    
    boolean output;
    RegisterPage rp;
    
    @BeforeClass
    public static void setUpClass() {
        instDrivers.setUrl("http://192.168.56.175:8080/TP-warWebSite/faces/faces/vistas/Registo/registo.xhtml");
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
       
    public RegistoUser(String email, String nome, String pass, String confPass, boolean out) {
        this.rp=new RegisterPage(email, nome, pass, confPass);
        this.output=out;
    }
    
    @Parameterized.Parameters
    public static Collection insercaoDadosParametrizaveis() {
        return Arrays.asList(new Object[][]{
            {"vit@gmail.com", "vitor", "1234", "123", false},
            {"cannavaro1@gmail.com", "fabio", "12" , "12" , true}
        });
    }
    
    public void registaForm(WebDriver w) throws InterruptedException{
        Thread.sleep(1000);
        w.findElement(By.id("formRegisto:txtEmail")).sendKeys(this.rp.getEmail());
        Thread.sleep(1000);
        w.findElement(By.id("formRegisto:txtNome")).sendKeys(this.rp.getNome());
        Thread.sleep(1000);
        w.findElement(By.id("formRegisto:txtPass")).sendKeys(this.rp.getPass());
        Thread.sleep(1000);
        w.findElement(By.id("formRegisto:txtNovoPass")).sendKeys(this.rp.getConfPass());
        Thread.sleep(1000);
        String s=w.getPageSource();
    }
    
    @Test
    public void testaRegisto() throws InterruptedException {
        WebDriver web = instDrivers.getInstanceDriver();
        instDrivers.setUrl("http://192.168.56.175:8080/TP-warWebSite/faces/faces/vistas/Registo/registo.xhtml");
        registaForm(web);
        web.findElement(By.id("formRegisto:btnConfirmar")).click();/*BOTAO É DO TIPO SUBMIT*/
        String xx=web.getCurrentUrl();
        if (web.getCurrentUrl().equals("http://192.168.56.175:8080/TP-warWebSite/faces/index.xhtml") == true && this.output == true) {
            assertTrue("Acertou", true);
        } else if (web.getCurrentUrl().equals("http://192.168.56.175:8080/TP-warWebSite/faces/vistas/Registo/registo.xhtml") == true && this.output == false) {
            assertTrue("Nao entrou, mas esta bem", true);
        } else {
            assertFalse("Problema", true);
        }
    }

}
