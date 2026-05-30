package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenCart_POM {

	WebDriver driver;
	WebDriverWait wait;

	String baseUrl = "https://tutorialsninja.com/demo/";

	public OpenCart_POM(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	By myAccount = By.xpath("//span[text()='My Account']");
	By registerLink = By.linkText("Register");
	By loginLink = By.linkText("Login");
	By logoutLink = By.linkText("Logout");

	By firstName = By.id("input-firstname");
	By lastName = By.id("input-lastname");
	By email = By.id("input-email");
	By telephone = By.id("input-telephone");
	By password = By.id("input-password");
	By confirmPassword = By.id("input-confirm");
	By privacyPolicy = By.name("agree");
	By continueBtn = By.xpath("//input[@value='Continue']");

	By loginEmail = By.id("input-email");
	By loginPassword = By.id("input-password");
	By loginButton = By.xpath("//input[@value='Login']");

	By searchBox = By.name("search");
	By searchButton = By.xpath("//button[contains(@class,'btn-default')]");

	By addCartFromListing = By.xpath("(//button[contains(@onclick,'cart.add')])[1]");
	By successAlert = By.xpath("//div[contains(@class,'alert-success')]");

	By cartButton = By.id("cart");
	By viewCartLink = By.xpath("//strong[contains(text(),'View Cart')]");
	By removeButton = By.xpath("//button[@data-original-title='Remove']");

	public void openHomePage() {
		driver.get(baseUrl);
	}

	public void openRegistrationPage() {
		openHomePage();
		wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
		wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
	}

	public void registerUser(String fname, String lname, String mail, String phone, String pass)
			throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(email).sendKeys(mail);
		driver.findElement(telephone).sendKeys(phone);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(confirmPassword).sendKeys(pass);

		wait.until(ExpectedConditions.elementToBeClickable(privacyPolicy)).click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();

		Thread.sleep(3000);
	}

	public void logoutAfterRegistration() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();

		Thread.sleep(3000);
	}

	public void openLoginPage() {
		openHomePage();
		wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
		wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
	}

	public void loginUser(String mail, String pass) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail)).sendKeys(mail);
		driver.findElement(loginPassword).sendKeys(pass);

		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

		Thread.sleep(3000);
	}

	public void searchProduct(String productName) {
		openHomePage();

		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		search.clear();
		search.sendKeys(productName);

		wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	}

	public void addProductToCart() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(addCartFromListing)).click();

		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert));

		System.out.println("Product Added To Cart Successfully");
	}

	public void removeProduct() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();

		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();

		Thread.sleep(3000);
	}

	public void checkout() throws InterruptedException {
		driver.get(baseUrl + "index.php?route=checkout/checkout");

		Thread.sleep(5000);

		System.out.println("Checkout page opened / manual checkout can be handled here");
	}

	public void verifyOrderConfirmation() throws InterruptedException {
		System.out.println("Order confirmation requires real order placement");
		Thread.sleep(5000);
	}

	public void logout() throws InterruptedException {
		openHomePage();

		wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();

		Thread.sleep(3000);
	}
}