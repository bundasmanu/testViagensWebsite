/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTests;

import Drivers.instDrivers;
import java.util.Arrays;
import java.util.Collection;
import logicadigital.viagensonlineteste.LoginPage;
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
public class Login {
    
    boolean output;
    LoginPage lp;
    
    @BeforeClass
    public static void setUpClass() {
        instDrivers.setUrl("http://192.168.56.175:8080/TP-warWebSite/faces/faces/vistas/login/login.xhtml");
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
    
    public Login(String email, String pass, boolean out) {
        this.lp=new LoginPage(email, pass);
        this.output=out;
    }
    
    @Parameterized.Parameters
    public static Collection insercaoDadosParametrizaveis() {
        return Arrays.asList(new Object[][]{
            {"joao@gmail.com", "123", false},
            {"vitor@gmail.com", "vitor", true}
        });
    }
    
    public void registaForm(WebDriver w) throws InterruptedException{
        Thread.sleep(1000);
        w.findElement(By.id("form:email")).sendKeys(this.lp.getEmail());/*CAIXA DE TEXTO COM O USERNAME DO UTILIZADOR*/
        Thread.sleep(1000);
        w.findElement(By.id("form:password")).sendKeys(this.lp.getPass());/*CAIXA DE TEXTO COM A PASS DO UTILIZADOR*/
        Thread.sleep(1000);
        w.findElement(By.id("form:btnEntryLink")).click();
        Thread.sleep(1000);
    }
    
    @Test
    public void testeLogin() throws InterruptedException{
        WebDriver x=instDrivers.getInstanceDriver();
        instDrivers.setUrl("http://192.168.56.175:8080/TP-warWebSite/faces/faces/vistas/login/login.xhtml");
        registaForm(x);
        if(x.getCurrentUrl().equals("http://192.168.56.175:8080/TP-warWebSite/faces/vistas/cliente/infoCliente.xhtml")==true && this.output==true){
            assertTrue("Login executado com sucesso",true);
        }
        else if(x.getCurrentUrl().equals("http://192.168.56.175:8080/TP-warWebSite/faces/vistas/login/login.xhtml")==true && this.output==false){
            assertTrue("Login Invalido", true);
        }
        else{
            assertFalse("Falhou",true);
        }
    }
}
