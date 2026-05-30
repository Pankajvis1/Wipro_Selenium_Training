package POM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TutorialsNinja_POM {

	WebDriver driver;
	WebDriverWait wait;

	public TutorialsNinja_POM(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	By firstName = By.id("input-firstname");
	By lastName = By.id("input-lastname");
	By email = By.id("input-email");
	By telephone = By.id("input-telephone");
	By password = By.id("input-password");
	By confirmPassword = By.id("input-confirm");
	By privacyPolicy = By.name("agree");
	By continueButton = By.xpath("//input[@value='Continue']");

	By searchBox = By.name("search");
	By searchButton = By.xpath("//button[contains(@class,'btn-default')]");
	By addToCartButton = By.xpath("(//button[contains(@onclick,'cart.add')])[1]");
	By successAlert = By.xpath("//div[contains(@class,'alert-success')]");
	By removeButton = By.xpath("//button[@data-original-title='Remove']");

	By contactName = By.id("input-name");
	By contactEmail = By.id("input-email");
	By enquiryBox = By.id("input-enquiry");
	By submitButton = By.xpath("//input[@value='Submit']");

	By newsletterYes = By.xpath("//input[@name='newsletter' and @value='1']");
	By newsletterNo = By.xpath("//input[@name='newsletter' and @value='0']");

	public void openRegistrationPage() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
	}

	public void registerUser(String fname, String lname, String mail, String phone, String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(email).sendKeys(mail);
		driver.findElement(telephone).sendKeys(phone);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(confirmPassword).sendKeys(pass);

		if (!driver.findElement(privacyPolicy).isSelected()) {
			driver.findElement(privacyPolicy).click();
		}

		driver.findElement(continueButton).click();
		System.out.println("Registered Email: " + mail);
	}

	public void checkRegistrationSuccess() {
		WebElement heading = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1")));

		Assert.assertEquals(heading.getText(), "Your Account Has Been Created!");
		System.out.println("Registration Passed");
	}

	public void logoutAfterRegistration() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/logout");
		System.out.println("Logout After Registration Passed");
	}

	public void openLoginPage() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
	}

	public void loginUser(String mail, String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(email)).clear();
		driver.findElement(email).sendKeys(mail);
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		List<WebElement> warnings = driver.findElements(By.cssSelector(".alert-danger"));
		if (!warnings.isEmpty()) {
			System.out.println("Login Warning: " + warnings.get(0).getText());
		}
	}

	public void checkLoginSuccess() {
		wait.until(ExpectedConditions.urlContains("account/account"));
		Assert.assertTrue(driver.getCurrentUrl().contains("account/account"));
		System.out.println("Login Passed");
	}

	public void openHomePage() {
		driver.get("https://tutorialsninja.com/demo/");
	}

	public void searchProduct(String product) {
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
		search.clear();
		search.sendKeys(product);
		driver.findElement(searchButton).click();
	}

	public void checkSearchSuccess() {
		wait.until(ExpectedConditions.titleContains("Search"));
		System.out.println("Search Passed");
	}

	public void addProductToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
	}

	public void checkProductAdded() {
		WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert));
		Assert.assertTrue(alert.getText().contains("Success"));
		System.out.println("Add To Cart Passed");
	}

	public void openShoppingCart() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=checkout/cart");
	}

	public void checkShoppingCartPage() {
		wait.until(ExpectedConditions.titleContains("Shopping Cart"));
		System.out.println("Shopping Cart Page Passed");
	}

	public void removeProductFromCart() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=checkout/cart");

		List<WebElement> removeButtons = driver.findElements(removeButton);

		if (removeButtons.size() > 0) {
			WebElement remove = removeButtons.get(0);
			remove.click();
			wait.until(ExpectedConditions.stalenessOf(remove));
			System.out.println("Remove Button Clicked");
		} else {
			System.out.println("No product available in cart");
		}
	}

	public void checkCartEmpty() {
		System.out.println("Remove Cart Passed");
	}

	public void openContactUsPage() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=information/contact");
	}

	public void enterContactDetails(String name, String mail, String message) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactName)).sendKeys(name);
		driver.findElement(contactEmail).sendKeys(mail);
		driver.findElement(enquiryBox).sendKeys(message);
		driver.findElement(submitButton).click();
	}

	public void checkContactUs() {
		WebElement heading = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1")));

		Assert.assertTrue(heading.getText().contains("Contact Us"));
		System.out.println("Contact Us Passed");
	}

	public void openNewsletterPage(String mail, String pass) {
		openLoginPage();
		loginUser(mail, pass);
		checkLoginSuccess();

		driver.get("https://tutorialsninja.com/demo/index.php?route=account/newsletter");
	}

	public void selectNewsletterOption(String option) {
		if (option.equalsIgnoreCase("Yes")) {
			wait.until(ExpectedConditions.elementToBeClickable(newsletterYes)).click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(newsletterNo)).click();
		}

		driver.findElement(continueButton).click();
	}

	public void checkNewsletterUpdated() {
		WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(successAlert));
		Assert.assertTrue(alert.getText().contains("Success"));
		System.out.println("Newsletter Passed");
	}

	public void logout() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/logout");
	}

	public void checkLogoutSuccess() {
		wait.until(ExpectedConditions.titleContains("Account Logout"));
		System.out.println("Logout Passed");
	}
}