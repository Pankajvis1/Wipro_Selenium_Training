package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(name = "uid")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "btnLogin")
    WebElement loginButton;

    public LoginPage() {
        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {
        username.clear();
        username.sendKeys(user);

        password.clear();
        password.sendKeys(pass);

        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        try {
            Thread.sleep(1000);
            return driver.findElements(By.linkText("New Customer")).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public String getAlertTextAndAccept() {
        String text = "";

        try {
            Thread.sleep(1000);
            Alert alert = driver.switchTo().alert();
            text = alert.getText();
            alert.accept();
        } catch (Exception e) {
            text = "";
        }

        return text;
    }
}