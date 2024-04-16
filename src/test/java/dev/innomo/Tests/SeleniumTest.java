package dev.innomo.Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import dev.innomo.Pages.HomePage;
import dev.innomo.Pages.ProductsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    public static ChromeDriver driver;

    static ExtentReports report;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/spark.html");
        extent.attachReporter(sparkReporter);
        HomePage.clickMenu();
        HomePage.clickOnlineProducts();
    }

    @Test
    void validateOnlineProductsTitles(){
        test = extent.createTest("Validate Shoe Titles","Validate different shoe types");
        ProductsPage.verifyFormalShoesTitle();
        ProductsPage.verifySportsShoesTitle();
        ProductsPage.verifySneakerShoesTitle();
        extent.flush();
    }

    @Test
    void validateFirstFormalShoes(){
        test = extent.createTest("validateFirstFormalShoes Shoe Title","Validate different shoe types");
        ProductsPage.verifyFormalShoesFirstName();

    }

    @Test
    void validateFirstSportsShoes(){
        test = extent.createTest("validateFirstSportsShoes Shoe Titles","Validate different shoe types");
        ProductsPage.verifySportsShoesFirstName();
    }

    @AfterSuite
    void cleanUp(){
        extent.flush();
    }
}
