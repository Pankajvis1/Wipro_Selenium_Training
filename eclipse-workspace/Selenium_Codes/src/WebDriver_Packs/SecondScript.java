package WebDriver_Packs;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondScript {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/downloads/");
        Thread.sleep(3000);

        String expectedtitle = "Selenium Download";
        String actualtitle = driver.getTitle(); // help to get current page title

        System.out.println("Expected Title is=" + expectedtitle);
        System.out.println("Actualtitle is=" + actualtitle);

        if (expectedtitle.equals(actualtitle)) {

            System.out.println("Title validation pass");
        }

        else
            System.out.println("Title validation fail");

        Thread.sleep(3000);

        driver.close();
    }
}