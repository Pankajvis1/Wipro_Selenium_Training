package WebDriver_Packs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckByClass {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/downloads/");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.findElement(By.className("DocSearch-Button")).click();

        Thread.sleep(2000);

        driver.findElement(By.className("DocSearch-Input")).sendKeys("Alerts");

        Thread.sleep(3000);

        driver.close();
    }
}