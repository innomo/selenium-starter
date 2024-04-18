package dev.innomo.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Locators2 {
    WebDriver webDriver = new ChromeDriver();
    @BeforeTest
//    void setUp(){
//        webDriver.manage().window().maximize();
//        webDriver.get("http://google.com");
//        webDriver.navigate().to("https://rahulshettyacademy.com");
//        webDriver.navigate().back();
//        webDriver.navigate().forward();
//    }
   @Test
   void locate() throws InterruptedException {
       webDriver.get("https://rahulshettyacademy.com/AutomationPractice/");
       //String text = webDriver.findElement(By.xpath("//header/div/button[1]")).getText();
       webDriver.findElement(By.id("name")).sendKeys("Inno");
      // webDriver.findElement(By.xpath("//input[@value=\"Alert\"]")).click();
       webDriver.findElement(By.xpath("//input[@value=\"Confirm\"]")).click();
        //System.out.println(webDriver.switchTo().alert().getText());
        Thread.sleep(3000);
       webDriver.switchTo().alert().dismiss();
       //System.out.println(text);

   }
   @Test
    void dropdows(){
        webDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
       Select select = new Select(webDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
       select.selectByIndex(3);
       WebElement firstSelectedOption = select.getFirstSelectedOption();
       System.out.println(firstSelectedOption);
   }

    @Test
    void checkboxs(){
        webDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Select select = new Select(webDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        select.selectByIndex(3);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println(firstSelectedOption);
    }

    @Test
    void alerts(){
        webDriver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Select select = new Select(webDriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        select.selectByIndex(3);
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println(firstSelectedOption);
    }


}
