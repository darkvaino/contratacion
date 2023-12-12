/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ucaldas.servicios;


import edu.ucaldas.servicios.DTO.PoliciaDTO;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author ucaldas
 */
public class ServicioPolicia implements IServicioPolicia{

    @Override
    public void accesWebPage(PoliciaDTO p) throws IOException, InterruptedException{
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://antecedentes.policia.gov.co:7005/WebJudicial/");
        Thread.sleep(5);
        
        WebElement accept = driver.findElement(By.xpath("//input[@id='aceptaOption:0']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", accept);
        
        Thread.sleep(10);
        
        WebElement enviar = driver.findElement(By.xpath("//button[@id='continuarBtn']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", enviar);      
        Thread.sleep(5000);
        
        driver.get("https://antecedentes.policia.gov.co:7005/WebJudicial/antecedentes.xhtml");        
        
        driver.findElement(By.xpath("//input[@id='cedulaInput']")).sendKeys(p.getCedula());
        Thread.sleep(10);
        Select select = new Select(driver.findElement(By.xpath("//select[@id='cedulaTipo']")));
        select.selectByIndex(1);
        Thread.sleep(10);
        
        Duration d1 = Duration.ofSeconds(10);
        Duration d2 = Duration.ofSeconds(20);
        
        new WebDriverWait(driver, d1).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        WebElement captcha = new WebDriverWait(driver, d2).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", captcha);
        
        Thread.sleep(5000);
        
        driver.close();        
    }
    
    
}
