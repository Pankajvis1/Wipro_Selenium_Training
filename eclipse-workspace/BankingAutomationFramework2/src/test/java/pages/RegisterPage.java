package pages;

import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;

    By registerLink = By.linkText("Register");
    By firstName = By.id("customer.firstName");
    By lastName = By.id("customer.lastName");
    By address = By.id("customer.address.street");
    By city = By.id("customer.address.city");
    By state = By.id("customer.address.state");
    By zip = By.id("customer.address.zipCode");
    By phone = By.id("customer.phoneNumber");
    By ssn = By.id("customer.ssn");
    By username = By.id("customer.username");
    By password = By.id("customer.password");
    By confirmPassword = By.id("repeatedPassword");
    By registerButton = By.xpath("//input[@value='Register']");

    public RegisterPage() {
        driver = DriverFactory.getDriver();
    }

    public void openRegisterPage() {
        driver.findElement(registerLink).click();
    }

    public void registerUser(String fname, String lname, String addr,
                             String cityName, String stateName, String zipCode,
                             String phoneNo, String ssnNo,
                             String user, String pass) {

        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(address).sendKeys(addr);
        driver.findElement(city).sendKeys(cityName);
        driver.findElement(state).sendKeys(stateName);
        driver.findElement(zip).sendKeys(zipCode);
        driver.findElement(phone).sendKeys(phoneNo);
        driver.findElement(ssn).sendKeys(ssnNo);
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
        driver.findElement(registerButton).click();
    }

    public boolean isRegistrationSuccessful() {
        return driver.getPageSource().contains("Your account was created successfully");
    }
}