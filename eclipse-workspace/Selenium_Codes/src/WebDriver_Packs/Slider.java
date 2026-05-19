package WebDriver_Packs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demoqa.com/slider");

        // slider
        WebElement slider = driver.findElement(
                By.xpath("//input[@type='range']"));

        Actions ac = new Actions(driver);

        // drag by x and y values
        ac.dragAndDropBy(slider, 50, 0).perform();

        Thread.sleep(3000);

        driver.close();
    }
}