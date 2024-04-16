package dev.innomo.Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import static dev.innomo.Tests.SeleniumTest.driver;
import static dev.innomo.Tests.SeleniumTest.*;

public class ProductsPage {

    public static String formalShoes = "FormalShoesTitle";
    public static String sportsShoes = "SportsShoesTitle";
    public static String sneakersShoes = "SneakerShoesTitle";
    public static String formalShoeDropdown = "formalshoedropdown";
    public static String sportsShoeDropdown = "sportsshoedropdown";
    public static String sneakerShoeDropdown = "sneakershoedropdown";
    public static String formalShoesTableBody = "/html/body/div[2]/table/tbody";
    public static String formalShoesFirstName = "/html/body/div[2]/table/tbody/tr[1]/td[1]";
    public static String sportsShoesFirstName = "/html/body/div[3]/table/tbody/tr[1]/td[1]";
    public static String sneakerShoesFirstName = "/html/body/div[4]/table/tbody/tr[0]";

    public static void verifyFormalShoesTitle(){
        String expected = "Formal Shoes";
        String actual = driver.findElement(By.className(formalShoes)).getText();
        System.out.println("Formal shoe: " + actual);
        Assert.assertEquals(expected,actual);
        if(expected.equals(actual)){
            test.log(Status.PASS, "Test passed for title verifyFormalShoesTitle");
        }
    }
    public static void verifySportsShoesTitle(){
        String expected = "Sports Shoes";
        String actual = driver.findElement(By.className(sportsShoes)).getText();
        System.out.println("Sports shoe: " + actual);
        Assert.assertEquals(expected,actual);
        if(expected.equals(actual)){
            test.log(Status.PASS, "Test passed for title verifySportsShoesTitle");
        }
    }
    public static void verifySneakerShoesTitle(){
        String expected = "Sneakers";
        String actual = driver.findElement(By.className(sneakersShoes)).getText();
        System.out.println("Sneakers shoe: " + actual);
        Assert.assertEquals(expected,actual);
    }

    public static void formalShoesDropdownClick(){
//        String expected = "Classic Cheltanham";
//        driver.findElement(By.className(formalShoeDropdown)).click();
//        String actual = driver.findElement(By.xpath(formalShoesFirstName)).getText();
//        Assert.assertEquals(actual,expected);
    }
    public static void sportsShoesDropdownClick(){
//        String expected = "Classic Cheltanham";
//        driver.findElement(By.className(formalShoeDropdown)).click();
//        String actual = driver.findElement(By.xpath(formalShoesFirstName)).getText();
//        Assert.assertEquals(actual,expected);
    }
    public static void sneakerShoesDropdownClick(){
//        String expected = "Classic Cheltanham";
//        driver.findElement(By.className(formalShoeDropdown)).click();
//        String actual = driver.findElement(By.xpath(formalShoesFirstName)).getText();
//        Assert.assertEquals(actual,expected);
    }
    public static void verifyFormalShoesFirstName(){
        String expected = "Classic Cheltenham";
        driver.findElement(By.className(formalShoeDropdown)).click();
        String actual = driver.findElement(By.xpath(formalShoesFirstName)).getText().trim();
        Assert.assertEquals(actual,expected);
    }

    public static void verifySportsShoesFirstName(){
        String expected = "Ultimate";
        driver.findElement(By.className(sportsShoeDropdown)).click();
        String actual = driver.findElement(By.xpath(sportsShoesFirstName)).getText().trim();
        Assert.assertEquals(actual,expected);
    }
    public static void getTitleSneakerShoesFirstName(){
        String expected = "Ultimate";
        driver.findElement(By.className(formalShoeDropdown)).click();
        String actual = driver.findElement(By.xpath(formalShoesFirstName)).getText();
        Assert.assertEquals(actual,expected);
    }

}
