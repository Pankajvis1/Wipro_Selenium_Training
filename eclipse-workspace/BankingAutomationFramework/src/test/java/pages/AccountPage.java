package pages;

import factory.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {

    WebDriver driver;

    By newAccountLink = By.linkText("New Account");
    By customerId = By.name("cusid");
    By accountType = By.name("selaccount");
    By initialDeposit = By.name("inideposit");
    By submitButton = By.name("button2");

    public AccountPage() {
        driver = DriverFactory.getDriver();
    }

    public void openNewAccountPage() {
        driver.findElement(newAccountLink).click();
    }

    public void createAccount(String custId, String type, String deposit) {

        driver.findElement(customerId).sendKeys(custId);

        Select select = new Select(driver.findElement(accountType));
        select.selectByVisibleText(type);

        driver.findElement(initialDeposit).sendKeys(deposit);

        driver.findElement(submitButton).click();
    }

    public boolean isAccountCreated() {
        try {
            Thread.sleep(1500);
            return driver.getPageSource().contains("Account Generated Successfully");
        } catch (Exception e) {
            return false;
        }
    }

    public String getAccountNumber() {
        return driver.findElement(
                By.xpath("//td[text()='Account ID']/following-sibling::td")
        ).getText();
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