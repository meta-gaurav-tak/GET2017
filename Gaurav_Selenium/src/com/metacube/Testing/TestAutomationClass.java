package com.metacube.Testing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAutomationClass {
  WebDriver driver;
  @BeforeMethod
  public void openURLToTest() {
      driver = new ChromeDriver();
      driver.get("http://automationpractice.com/index.php");
  }
  
  @Test(priority=2)
  public void signInForgotPasswordTest() throws InterruptedException {
      Thread.sleep(3000);
      driver.findElement(By.linkText("Sign in")).click();
      Thread.sleep(3000);
      driver.findElement(By.linkText("Forgot your password?")).click();
      Assert.assertEquals(driver.getTitle(), "Forgot your password - My Store");
      Thread.sleep(5000);
  }
  
  @Test(priority=1)
  public void createAccountRedirectionTest() throws InterruptedException {
      Thread.sleep(7000);
      driver.findElement(By.linkText("Sign in")).click();
      Thread.sleep(3000);
      driver.findElement(By.id("email_create")).sendKeys("g"+Math.random()+"@gmail.com");
      Thread.sleep(1000);
      driver.findElement(By.id("SubmitCreate")).click();
      Thread.sleep(3000);
      Assert.assertEquals(driver.getCurrentUrl(), 
              "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
      
  }
  
  @AfterMethod
  public void closeURLToTest() throws InterruptedException {
      driver.close();       
  }
  
}
