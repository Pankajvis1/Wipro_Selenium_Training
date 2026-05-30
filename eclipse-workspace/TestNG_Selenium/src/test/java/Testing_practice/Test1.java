package Testing_practice;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test1 {

    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void f() {
        driver.findElement(By.id("firstName")).sendKeys("Pankaj");
        driver.findElement(By.id("lastName")).sendKeys("Vishwakarma");
        driver.findElement(By.id("userEmail")).sendKeys("Pankaj@gmail.com");
    }

    @Test(priority = 2)
    public void g() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");

        // Gender radio button
        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();

        Thread.sleep(1000);

        driver.findElement(By.id("userNumber")).sendKeys("7357253728");

        // Open Date Picker
        driver.findElement(By.id("dateOfBirthInput")).click();

        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("3");

        Thread.sleep(1000);

        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        Select selectYear = new Select(year);
        selectYear.selectByValue("2000");
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}