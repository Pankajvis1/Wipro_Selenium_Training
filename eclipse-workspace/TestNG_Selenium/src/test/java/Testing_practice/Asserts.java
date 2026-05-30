package Testing_practice;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import org.testng.asserts.SoftAssert;

public class Asserts {

    WebDriver driver;

    @BeforeTest
    public void beforeTest() {

        driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/");

        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void titlevalidation() {

        SoftAssert soft = new SoftAssert();

        String expectedtitle = "Selenium";

        String actualtitle = driver.getTitle();

        AssertJUnit.assertEquals(actualtitle,
                expectedtitle,
                "Title validation failed");

        soft.assertAll();
    }

    @AfterTest
    public void afterTest() {

        driver.quit();

        System.out.println("Browser Closed");
    }
}