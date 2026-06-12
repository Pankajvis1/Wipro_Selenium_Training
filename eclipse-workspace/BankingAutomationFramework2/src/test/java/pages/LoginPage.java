package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By username = By.name("username");
    By password = By.name("password");
    By loginButton = By.xpath("//input[@value='Log In']");
    By logoutLink = By.linkText("Log Out");
    
    public LoginPage() {
        driver = DriverFactory.getDriver();
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        return driver.getPageSource().contains("Accounts Overview");
    }

    public boolean isLoginFailed() {
        return driver.getPageSource().contains("The username and password could not be verified");
    }
    
    public void logout() {
        driver.findElement(logoutLink).click();
    }

    public boolean isLogoutSuccessful() {
        return driver.findElements(username).size() > 0;
    }
}