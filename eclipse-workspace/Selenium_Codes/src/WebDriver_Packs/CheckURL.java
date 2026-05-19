package WebDriver_Packs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckURL {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/downloads/");
        Thread.sleep(3000);

        String expectedURL = "https://www.selenium.dev/downloads/";
        String actualURL = driver.getCurrentUrl();

        System.out.println("Expected URL is = " + expectedURL);
        System.out.println("Actual URL is = " + actualURL);

        if (expectedURL.equals(actualURL)) {

            System.out.println("URL validation pass");
        }

        else {

            System.out.println("URL validation fail");
        }

        Thread.sleep(3000);

        driver.close();
    }
}