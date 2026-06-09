package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {

    private static final Logger log =
            LoggerFactory.getLogger(LoginPage.class);

    WebDriver driver;

    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {

        log.info("Entering username");

        driver.findElement(username).sendKeys(user);

        log.info("Entering password");

        driver.findElement(password).sendKeys(pass);

        log.info("Clicking login button");

        driver.findElement(loginButton).click();
    }
}