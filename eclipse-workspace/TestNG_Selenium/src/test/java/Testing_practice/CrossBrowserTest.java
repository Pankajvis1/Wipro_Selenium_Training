package Testing_practice;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.safari.SafariDriver;

import org.testng.annotations.Test;

public class CrossBrowserTest {

    WebDriver driver;

    @Test(groups = {"Smoke", "Regression"})
    public void chrome() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.selenium.dev/");

        System.out.println("Chrome Executed");

        driver.quit();
    }

    @Test(groups = {"Smoke", "Regression"})
    public void brave() {

        ChromeOptions options = new ChromeOptions();

        options.setBinary(
                "/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.selenium.dev/");

        System.out.println("Brave Executed");

        driver.quit();
    }

    @Test(groups = {"Regression"})
    public void safari() {

        driver = new SafariDriver();

        driver.manage().window().maximize();

        driver.get("https://www.selenium.dev/");

        System.out.println("Safari Executed");

        driver.quit();
    }
}