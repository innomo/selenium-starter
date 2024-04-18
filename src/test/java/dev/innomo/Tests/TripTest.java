package dev.innomo.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TripTest {
    WebDriver webDriver = new ChromeDriver();
    String type = "Round Trip";
    String passengers = "2";
    String departingFrom = "London";
    String arriving = "Paris";
    String on = "August 1";
    String returning = "August 7";
    String serviceClass = "First Class";
    @BeforeSuite
    void setup(){

    }
    @Test
    void login(){
//        webDriver.findElement(By.name("userName")).sendKeys("tutorial");
//        webDriver.findElement(By.name("password")).sendKeys("tutorial");
//        webDriver.findElement(By.cssSelector("input[value=\"Submit\"]")).click();
    }
    @Test
    void bookFlight(){
        webDriver.get("https://demo.guru99.com/test/newtours/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.findElement(By.name("userName")).sendKeys("tutorial");
        webDriver.findElement(By.name("password")).sendKeys("tutorial");
        webDriver.findElement(By.cssSelector("input[value=\"Submit\"]")).click();
        webDriver.findElement(By.linkText("Flights")).click();
        webDriver.findElement(By.xpath("//input[@value=\"roundtrip\"]")).click();
        Select selectPassenger = new Select(webDriver.findElement(By.name("passCount")));
        selectPassenger.selectByValue(passengers);
        new Select(webDriver.findElement(By.name("fromPort"))).selectByValue(departingFrom);
        new Select(webDriver.findElement(By.name("toPort"))).selectByVisibleText(arriving);
        new Select(webDriver.findElement(By.name("fromMonth"))).selectByVisibleText(on.split(" ")[0]);
        new Select(webDriver.findElement(By.name("fromDay"))).selectByValue(on.split(" ")[1]);
        new Select(webDriver.findElement(By.name("toMonth"))).selectByVisibleText(returning.split(" ")[0]);
        new Select(webDriver.findElement(By.name("toDay"))).selectByValue(returning.split(" ")[1]);
        webDriver.findElement(By.xpath("//input[@value=\"First\"]")).click();
        webDriver.findElement(By.name("findFlights")).click();
    }
    @Test
    public void checkOut(){
        webDriver.get("https://www.saucedemo.com/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        webDriver.findElement(By.id("user-name")).sendKeys("standard_user");
        webDriver.findElement(By.id("password")).sendKeys("secret_sauce");
        webDriver.findElement(By.name("login-button")).click();
        //Add products
        int count = 2;
        List<WebElement> products = webDriver.findElements(By.className("inventory_item"));
        products.stream().limit(2).forEach(product -> {
            WebElement element;
            product.findElement(By.xpath("//button[contains(text(), \"Add to cart\")]")).click();
        });
        //Assert.assertEquals(products.size(),2);
        webDriver.findElement(By.cssSelector("a[class=\"shopping_cart_link\"]")).click();
        webDriver.findElement(By.xpath("//button[text()=\"Checkout\"]")).click();
        webDriver.findElement(By.name("firstName")).sendKeys("Trinity");
        webDriver.findElement(By.name("lastName")).sendKeys("Mona");
        webDriver.findElement(By.name("postalCode")).sendKeys("2012");
        webDriver.findElement(By.id("continue")).click();
        webDriver.findElement(By.cssSelector("button[data-test=\"finish\"]")).click();

    }
}
