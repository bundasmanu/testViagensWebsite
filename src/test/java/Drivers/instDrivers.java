/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Armando
 */
public class instDrivers {
    
    static WebDriver driver;
    
    public static void initWebDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    
    public static WebDriver getInstanceDriver(){
        return driver;
    }
    
    public static void setUrl(String u){
        driver.manage().window().maximize();
        driver.get(u);
    }

    public static void close(){
        //driver.close();
        driver.quit();
    }
}
