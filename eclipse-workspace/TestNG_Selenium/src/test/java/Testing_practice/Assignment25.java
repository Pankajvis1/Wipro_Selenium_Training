package Testing_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment25 {

    WebDriver driver;
    WebDriverWait wait;

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][] {

                { "username", "password" },

                
                { "admin", "admin" },
                { "invalid", "password" },
                { "username", "wrongpass" },
                { "", "" },
                { "12345", "12345" }
        };
    }

    @Test(dataProvider = "loginData", alwaysRun = true)
    public void loginTest(String username, String password)
            throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement user =
                driver.findElement(By.id("user_login"));

        user.sendKeys(username);

        WebElement pass =
                driver.findElement(By.id("user_password"));

        pass.sendKeys(password);

        driver.findElement(By.name("submit"))
                .click();

        Thread.sleep(3000);

        System.out.println(
                "Username: " + username +
                " Password: " + password);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {

        if (driver != null) {

            driver.quit();
        }
    }
}