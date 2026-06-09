package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    protected static final Logger log =
            LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod
    public void setup() {

        log.info("Launching Chrome Browser");

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        log.info("SauceDemo Application Opened");
    }

    @AfterMethod
    public void tearDown() {

        log.info("Closing Browser");

        if (driver != null) {
            driver.quit();
        }
    }
}