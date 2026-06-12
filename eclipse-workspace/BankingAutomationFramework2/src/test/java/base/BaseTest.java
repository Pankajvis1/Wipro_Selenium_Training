package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utilities.ExtentManager;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    protected Properties prop;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) throws Exception {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);

        driver = DriverFactory.initDriver(browser);
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @AfterSuite
    public void flushReport() {
        ExtentManager.getExtent().flush();
    }
}