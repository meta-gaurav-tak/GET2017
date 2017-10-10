package com.metacube.Testing;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAutomation1 {
  
  @Test
  public void f() {
      System.out.println("in test method");
  }
  @AfterTest
  public void f2() {
      System.out.println("in after test method");
  }
  @BeforeTest
  public void f3() {
      System.out.println("in before test method");
  }
}
