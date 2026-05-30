package Testing_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POM_Flipkart {

    WebDriver driver;
    WebDriverWait wait;

    public POM_Flipkart(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By closePopup = By.xpath("/html/body/div[5]/div/span");
    By loginLink = By.xpath("//span[normalize-space()='Login']");
    By mobileNumber = By.xpath("//input[contains(@class,'c3Bd2c') and @type='text']");
    By loginButton = By.xpath("//button[normalize-space()='Request OTP']");
    By searchBox = By.name("q");
    By appleLaptop = By.xpath("//a[@class='pIpigb' and @title='Apple MacBook Air (M5, 2026) M5 - (16 GB/512 GB SSD/Tahoe) MDHE4HN/A']");
    By productDetails = By.xpath("//*[name()='svg' and .//*[name()='path' and contains(@d,'m208 96-80 80-80-80')]]/ancestor::*[self::button or self::div][1]");
    By addToCart = By.xpath("//div[@class='css-g5y9jx' and contains(@style,'z-index: 2')]");
    By cart = By.xpath("//span[normalize-space()='Cart']");
    By changeBtn = By.xpath("//div[contains(text(),'Change')]");
    By addressName = By.xpath("//div[contains(text(),'Karol Bagh')]");
    By logo = By.xpath("//header//img");
    By myProfile = By.xpath("//div[text()='My Profile']");
    By editBtn = By.xpath("//span[text()='Edit']");
    By firstName = By.xpath("//input[@type='text' and @name='firstName']");
    By saveBtn = By.xpath("//button[@type='submit' and normalize-space()='SAVE']");
    By cartIcon = By.xpath("//img[@alt='Cart' and contains(@src,'cart')]");
    By removeBtn = By.xpath("//div[@dir='auto' and normalize-space()='Remove']");

    public void closePopup() {
        try {
            driver.findElement(closePopup).click();
        } catch (Exception e) {
            System.out.println("Popup not displayed");
        }
    }

    public void login(String mobileNo) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumber)).sendKeys(mobileNo);
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        Thread.sleep(20000);
    }

    public void searchProduct(String productName) throws InterruptedException {
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        search.clear();
        search.sendKeys(productName);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(4000);
    }

    public void openAppleLaptop(String productName) throws InterruptedException {
        searchProduct(productName);

        wait.until(ExpectedConditions.elementToBeClickable(appleLaptop)).click();

        Thread.sleep(3000);

        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
        }
    }

    public void viewProductDetails(String productName) throws InterruptedException {
        openAppleLaptop(productName);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement details = wait.until(ExpectedConditions.elementToBeClickable(productDetails));

        js.executeScript("arguments[0].scrollIntoView({block:'center'});", details);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", details);

        Thread.sleep(3000);
    }

    public void addToCart(String productName) throws InterruptedException {
        openAppleLaptop(productName);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement addCart = wait.until(ExpectedConditions.elementToBeClickable(addToCart));

        js.executeScript("arguments[0].click();", addCart);

        Thread.sleep(2000);
    }

    public void changeAddress() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
        wait.until(ExpectedConditions.elementToBeClickable(changeBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressName)).click();

        Thread.sleep(2000);
    }

    public void changeName(String newName) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(logo)).click();
        wait.until(ExpectedConditions.elementToBeClickable(myProfile)).click();
        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();

        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));

        Actions ac = new Actions(driver);
        ac.doubleClick(name).perform();

        Thread.sleep(1000);

        name.sendKeys(Keys.BACK_SPACE);
        name.sendKeys(newName);

        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();

        Thread.sleep(1500);
    }

    public void removeItem() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(removeBtn)).click();

        Thread.sleep(2000);
    }
}