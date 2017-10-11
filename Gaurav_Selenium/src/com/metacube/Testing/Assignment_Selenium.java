package com.metacube.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Assignment_Selenium {
    public static void automateSignin(WebDriver driver) {
        
        driver.get("http://automationpractice.com/index.php");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.linkText("Sign in")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("email")).sendKeys("abc@xyz.com");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("passwd")).sendKeys("testing123");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("SubmitLogin")).click();
        
    }
}
