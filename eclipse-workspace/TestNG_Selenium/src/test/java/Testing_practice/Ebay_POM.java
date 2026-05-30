package Testing_practice;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class Ebay_POM {

	WebDriver driver;
	WebDriverWait wait;

	public Ebay_POM(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	By firstName = By.id("firstname");
	By lastName = By.id("lastname");
	By email = By.id("Email");
	By password = By.id("password");

	By userId = By.id("userid");
	By continueBtn = By.id("signin-continue-btn");

	By searchBox = By.id("gh-ac");
	By searchBtn = By.id("gh-search-btn");

	By firstProduct = By.xpath("(//a[contains(@class,'s-item__link')])[3]");
	By addToCart = By.xpath("//span[text()='Add to cart']");
	By removeButton = By.xpath("//button[contains(text(),'Remove')]");
	By checkoutButton = By.xpath("//button[contains(text(),'Go to checkout')]");

	By accountMenu = By.xpath("//button[contains(@aria-label,'Your eBay')]");
	By signOut = By.xpath("//a[contains(text(),'Sign out')]");

	public void openRegistrationPage() {
		driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2Fn%2Ferror");
	}

	public void registerUser(String fname, String lname, String mail, String pass) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(email).sendKeys(mail);
		driver.findElement(password).sendKeys(pass);

		System.out.println("Solve CAPTCHA/OTP manually if shown");
		Thread.sleep(30000);
	}

	public void openLoginPage() {
		driver.get("https://signin.ebay.com/");
	}

	public void loginUser(String username) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(userId)).sendKeys(username);
		wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();

		System.out.println("Enter password/OTP/CAPTCHA manually");
		Thread.sleep(40000);
	}

	public void searchProduct(String productName) {

		driver.get("https://www.ebay.com/");

		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		search.clear();
		search.sendKeys(productName);

		wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
	}

	public void addProductToCart() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();

		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();

		Thread.sleep(5000);
	}

	public void removeProduct() throws InterruptedException {

		driver.get("https://cart.ebay.com/");

		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();

		Thread.sleep(3000);
	}

	public void checkout() throws InterruptedException {

		driver.get("https://cart.ebay.com/");

		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();

		System.out.println("Handle login/payment/security manually");
		Thread.sleep(60000);
	}

	public void verifyOrderConfirmation() throws InterruptedException {

		System.out.println("Complete payment/order manually if required");
		Thread.sleep(60000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//*[contains(text(),'Thank you') or contains(text(),'confirmed') or contains(text(),'order')]")));
	}

	public void logout() throws InterruptedException {

		driver.get("https://www.ebay.com/");

		Thread.sleep(5000);

		wait.until(ExpectedConditions.elementToBeClickable(accountMenu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(signOut)).click();

		Thread.sleep(3000);
	}
}