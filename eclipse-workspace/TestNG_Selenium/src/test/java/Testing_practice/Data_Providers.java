package Testing_practice;

import org.testng.annotations.Test;


import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.safari.SafariDriver;

import org.testng.annotations.DataProvider;


public class Data_Providers {

    WebDriver driver;

    @DataProvider(name = "browsers" , parallel = false)
    public Object[][] dp() {

        return new Object[][] {

                { "chrome" },
                { "brave" },
                { "safari" }

        };
    }

    @Test(dataProvider = "browsers" )
    public void crossbrowser_test(String browser)
            throws InterruptedException {

        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();
        }

        else if (browser.equalsIgnoreCase("brave")) {

            ChromeOptions options =
                    new ChromeOptions();

            // Brave Browser Path for Mac
            options.setBinary(
                    "/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");

            driver = new ChromeDriver(options);
        }

        else if (browser.equalsIgnoreCase("safari")) {

            driver = new SafariDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.selenium.dev/");

        System.out.println(
                "Browser Opened: " + browser);

        System.out.println(
                "Title: " + driver.getTitle());

        Thread.sleep(3000);

        // Quit current browser
        driver.quit();

        System.out.println(
                "Browser Closed: " + browser);
    }
}