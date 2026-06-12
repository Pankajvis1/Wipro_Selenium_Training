package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {

    WebDriver driver;

    By openNewAccountLink = By.linkText("Open New Account");
    By accountType = By.id("type");
    By fromAccount = By.id("fromAccountId");
    By openAccountButton = By.xpath("//input[@value='Open New Account']");
    By newAccountId = By.id("newAccountId");

    public AccountPage() {
        driver = DriverFactory.getDriver();
    }

    public void openNewAccountPage() {
        driver.findElement(openNewAccountLink).click();
    }

    public void createSavingsAccount() {
        new Select(driver.findElement(accountType)).selectByVisibleText("SAVINGS");
        driver.findElement(openAccountButton).click();
    }

    public boolean isAccountCreated() {
        return driver.getPageSource().contains("Account Opened!");
    }

    public String getNewAccountNumber() {
        return driver.findElement(newAccountId).getText();
    }
}