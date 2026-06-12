package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferPage {

    WebDriver driver;

    By transferLink = By.linkText("Transfer Funds");
    By amount = By.id("amount");
    By transferButton = By.xpath("//input[@value='Transfer']");

    public TransferPage() {
        driver = DriverFactory.getDriver();
    }

    public void openTransferPage() {
        driver.findElement(transferLink).click();
    }

    public void transferAmount(String amt) {
        driver.findElement(amount).sendKeys(amt);
        driver.findElement(transferButton).click();
    }

    public boolean isTransferSuccessful() {
        return driver.getPageSource().contains("Transfer Complete!");
    }
}