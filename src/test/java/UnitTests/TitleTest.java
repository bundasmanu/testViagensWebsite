package UnitTests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Drivers.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Armando
 */
public class TitleTest {
    
    public TitleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instDrivers.setUrl("http://192.168.56.175:8080/TP-warWebSite/faces/index.xhtml");
    }
    
    @AfterClass
    public static void tearDownClass() throws InterruptedException {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void getTitle() throws InterruptedException{
        String titleName= instDrivers.getInstanceDriver().getTitle();
        Thread.sleep(1000);
        String esperado="Facelet Title";
        if(titleName.equals(esperado)==true){
            assertTrue("Acertou", true);
        }
    }
    
}
