package com.metacube.Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebTesting {
    public static void main(String args[]) {
        WebDriver driver = new FirefoxDriver();
        Assignment_Selenium.automateSignin(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriver ieDriver = new InternetExplorerDriver();
        Assignment_Selenium.automateSignin(ieDriver);
    }
}
