package Testing_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment_1 {

    WebDriver driver;

    @DataProvider(name = "searchData")
    public Object[][] searchData() {

        return new Object[][] {
                { "ipad" },
                { "bag" },
                { "laptop" },
                { "fan" },
                { "iphone" },
                { "samsung" }
        };
    }

    @Test(dataProvider = "searchData")
    public void validateSearch(String product) throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.flipkart.com/");

        try {
            driver.findElement(By.xpath("/html/body/div[5]/div/span")).click();
        } catch (Exception e) {
            System.out.println("Popup not displayed");
        }

        WebElement searchBox = driver.findElement(By.name("q"));

        Assert.assertTrue(
                searchBox.isDisplayed(),
                "Search box is not displayed");

        Assert.assertTrue(
                searchBox.isEnabled(),
                "Search box is not clickable");

        searchBox.sendKeys(product);

        searchBox.sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        System.out.println("Searched Product: " + product);

        driver.quit();
    }
}