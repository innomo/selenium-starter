package dev.innomo.Pages;

import org.openqa.selenium.By;

import static dev.innomo.Tests.SeleniumTest.driver;

public class HomePage {

    public static String menu = "//*[@id=\"menuToggle\"]/input";
    public static String onlineProducts = "Online Products";

    public static void clickMenu(){
        driver.findElement(By.xpath(menu)).click();
    }

    public static void clickOnlineProducts(){

        driver.findElement(By.linkText(onlineProducts)).click();
    }
}
