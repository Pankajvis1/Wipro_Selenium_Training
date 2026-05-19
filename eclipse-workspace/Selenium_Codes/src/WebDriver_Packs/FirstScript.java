package WebDriver_Packs;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/downloads/");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.findElement(By.id("Layer_1")).click();

        Thread.sleep(3000);

        driver.close();
    }
}