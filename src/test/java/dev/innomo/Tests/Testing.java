package dev.innomo.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

public class Testing {
    WebDriver webDriver = new ChromeDriver();
    final String baseURL = "https://rahulshettyacademy.com/locatorspractice/";

    @BeforeTest
    public void setUp(){
        webDriver.get(baseURL);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void sampleTest(){
        webDriver.findElement(By.id("inputUsername")).sendKeys("inno");
        webDriver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        webDriver.findElement(By.cssSelector("input[value='agreeTerms'")).click();
        webDriver.findElement(By.cssSelector("input[value='rmbrUsername'")).click();
        webDriver.findElement(By.cssSelector("button.signInBtn")).click();
    }

    @Test
    public void forgotPasswordTest() throws InterruptedException {

        webDriver.findElement(By.linkText("Forgot your password?")).click();
        webDriver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("inno");
        webDriver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("inno@mail.com");
        webDriver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("2376876572");
//        cssSelector:
//
//        new WebDriverWait(getWebDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.footer")));
//        new WebDriverWait(getWebDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[formcontrolname=reportingDealPermission][ng-reflect-name=reportingDealPermission]"))).click();
//        xpath:
//
//        new WebDriverWait(getWebDriver(), 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='footer']")));
//        new WebDriverWait(getWebDriver(), 10).until(ExpectedConditions.element
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.reset-pwd-btn"))).click();
          WebDriverWait webDriverWait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
          webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.reset-pwd-btn"))).click();

          String text = webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.className("infoMsg")))).getText();
        System.out.println(text.split("'").length);
        String passwordReset = text.split("'")[1];
        String[] textArray = text.split("'");
        webDriver.findElement(By.cssSelector("div button[class=\"go-to-login-btn\"]")).click();
       // System.out.println("lk: "+textArray);
        //        WebElement element = driver.findElement(By.xpath("//div[@class='footer']"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).click().build().perform();
        //webDriver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.cssSelector("input#inputUsername")).sendKeys("inno");
        webDriver.findElement(By.name("inputPassword")).sendKeys(passwordReset);
        //webDriver.findElement(By.cssSelector("button.signInBtn")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.signInBtn"))).click();
//        Thread.sleep(Duration.ofSeconds(5));
//        webDriver.findElement(By.cssSelector("button[class*=\"signInBtn\"")).click();
//        webDriver.findElement(By.cssSelector("button[class*=\"signInBtn\"")).click();
       // webDriverWait.until(ExpectedConditions.visibilityOf( webDriver.findElement(By.cssSelector("button[class*=\"signInBtn\"")))).click();
//
//        webDriver.findElement(By.cssSelector("input[value='agreeTerms'")).click();
//        webDriver.findElement(By.cssSelector("input[value='rmbrUsername'")).click();
//        webDriver.findElement(By.className("signInBtn")).click();
//        String errorText = webDriver.findElement(By.cssSelector("p.error")).getText();
//        System.out.println(errorText);
    }

    @Test
    public void LoginFailTest(){

        webDriver.findElement(By.cssSelector("input#inputUsername")).sendKeys("inno");
        webDriver.findElement(By.name("inputPassword")).sendKeys("srahulshettyacademy");

        webDriver.findElement(By.cssSelector("input[value='agreeTerms'")).click();
        webDriver.findElement(By.cssSelector("input[value='rmbrUsername'")).click();
        webDriver.findElement(By.className("signInBtn")).click();
        String errorText = webDriver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(errorText);
    }
    @AfterTest
    public void closeSetup(){
        webDriver.close();
    }
}
