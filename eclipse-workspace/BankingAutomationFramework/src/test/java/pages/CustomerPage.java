package pages;

import factory.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage {

    WebDriver driver;

    By newCustomerLink = By.linkText("New Customer");
    By customerName = By.name("name");
    By genderMale = By.xpath("//input[@name='rad1' and @value='m']");
    By dob = By.name("dob");
    By address = By.name("addr");
    By city = By.name("city");
    By state = By.name("state");
    By pin = By.name("pinno");
    By mobile = By.name("telephoneno");
    By email = By.name("emailid");
    By password = By.name("password");
    By submitButton = By.name("sub");

    public CustomerPage() {
        driver = DriverFactory.getDriver();
    }

    public void openNewCustomerPage() {
        driver.findElement(newCustomerLink).click();
    }

    public void addCustomer(String name, String dateOfBirth, String addr,
                            String cityName, String stateName, String pinCode,
                            String phone, String emailId, String pass) {

        driver.findElement(customerName).sendKeys(name);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();",
                driver.findElement(genderMale));

        WebElement dobElement = driver.findElement(dob);
        js.executeScript("arguments[0].value='1999-01-01';", dobElement);

        driver.findElement(address).sendKeys(addr);
        driver.findElement(city).sendKeys(cityName);
        driver.findElement(state).sendKeys(stateName);
        driver.findElement(pin).sendKeys(pinCode);
        driver.findElement(mobile).sendKeys(phone);

        String uniqueEmail = "pankaj" + System.currentTimeMillis() + "@gmail.com";
        driver.findElement(email).sendKeys(uniqueEmail);

        driver.findElement(password).sendKeys(pass);
        driver.findElement(submitButton).click();
    }

    public boolean isCustomerCreated() {
        try {
            Thread.sleep(1500);
            return driver.getPageSource().contains("Customer Registered Successfully");
        } catch (Exception e) {
            return false;
        }
    }

    public String getCustomerId() {
        return driver.findElement(
                By.xpath("//td[text()='Customer ID']/following-sibling::td")
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