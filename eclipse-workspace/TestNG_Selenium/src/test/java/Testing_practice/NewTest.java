package Testing_practice;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class NewTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void verifyLogin() throws InterruptedException {

        driver.findElement(By.id("username"))
              .sendKeys("tomsmith");

        Thread.sleep(2000);

        driver.findElement(By.name("password"))
              .sendKeys("SuperSecretPassword!");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@type='submit']"))
              .click();

        Thread.sleep(2000);

        String actualMessage = driver.findElement(By.id("flash"))
                                     .getText();

        System.out.println(actualMessage);

        AssertJUnit.assertTrue(actualMessage.contains("You logged into a secure area!"));

    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {

        Thread.sleep(3000);

        driver.quit();
    }
}