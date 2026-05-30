package Testing_practice;

import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class FlipKartTest {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void beforeTest() throws InterruptedException {

		driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		Thread.sleep(3000);

		try {
			driver.findElement(By.xpath("/html/body/div[5]/div/span")).click();
		} catch (Exception e) {
			System.out.println("Popup not displayed");
		}
	}

	@Test
	public void login() throws InterruptedException {

		WebElement loginLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Login']")));

		loginLink.click();

		Thread.sleep(2000);

		WebElement mobileNumber = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[contains(@class,'c3Bd2c') and @type='text']")));

		mobileNumber.sendKeys("7275656529");

		WebElement loginButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Request OTP']")));

		loginButton.click();

		Thread.sleep(2000);

		System.out.println("Login Test Executed");
	}

	@Test(dependsOnMethods = "login")
	public void multiple_search() throws InterruptedException {

		List<String> products = Arrays.asList("iphone", "ipad", "macbook");

		for (String item : products) {

			driver.get("https://www.flipkart.com/");

			Thread.sleep(3000);

			try {
				driver.findElement(By.xpath("/html/body/div[5]/div/span")).click();
			} catch (Exception e) {
				System.out.println("Popup not displayed");
			}

			WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

			searchBox.clear();

			searchBox.sendKeys(item);

			Thread.sleep(1000);

			searchBox.sendKeys(Keys.ENTER);

			System.out.println("Searched Product: " + item);

			Thread.sleep(4000);
		}
	}

	@Test(dependsOnMethods = "multiple_search")
	public void view_product_details() throws InterruptedException {

		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

		searchBox.sendKeys("Apple Laptop");

		searchBox.sendKeys(Keys.ENTER);

		Thread.sleep(4000);

		WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//a[@class='pIpigb' and @title='Apple MacBook Air (M5, 2026) M5 - (16 GB/512 GB SSD/Tahoe) MDHE4HN/A']")));

		product.click();

		Thread.sleep(3000);

		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,1200)");

		Thread.sleep(2000);

		WebElement details = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[name()='svg' and .//*[name()='path' and contains(@d,'m208 96-80 80-80-80')]]/ancestor::*[self::button or self::div][1]")));

		js.executeScript("arguments[0].scrollIntoView({block:'center'});", details);

		Thread.sleep(1000);

		js.executeScript("arguments[0].click();", details);

		Thread.sleep(3000);

		System.out.println("Viewed Product Details");
	}

	@Test(dependsOnMethods = "view_product_details")
	public void add_to_cart() throws InterruptedException {

		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

		searchBox.sendKeys("Apple Laptop");

		searchBox.sendKeys(Keys.ENTER);

		Thread.sleep(4000);

		WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//a[@class='pIpigb' and @title='Apple MacBook Air (M5, 2026) M5 - (16 GB/512 GB SSD/Tahoe) MDHE4HN/A']")));

		product.click();

		Thread.sleep(3000);

		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,1200)");

		Thread.sleep(2000);

		WebElement details = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[name()='svg' and .//*[name()='path' and contains(@d,'m208 96-80 80-80-80')]]/ancestor::*[self::button or self::div][1]")));

		js.executeScript("arguments[0].click();", details);

		Thread.sleep(3000);

		WebElement addToCart = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='css-g5y9jx' and contains(@style,'z-index: 2')]")));

		addToCart.click();

		Thread.sleep(2000);

		System.out.println("Product Added To Cart");
	}

	@Test(dependsOnMethods = "add_to_cart")
	public void change_Address() throws InterruptedException {

		WebElement cart = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Cart']")));

		cart.click();

		WebElement changeBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Change')]")));

		changeBtn.click();

		Thread.sleep(2000);

		WebElement addressName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Karol Bagh')]")));

		addressName.click();

		Thread.sleep(2000);

		System.out.println("Change Address Executed");
	}

	@Test(dependsOnMethods = "change_Address")
	public void Change_name() throws InterruptedException {

		WebElement logo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header//img")));

		logo.click();

		Thread.sleep(1000);

		WebElement myProfile = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='My Profile']")));

		myProfile.click();

		Thread.sleep(1000);

		WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Edit']")));

		editBtn.click();

		Thread.sleep(1000);

		WebElement firstName = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text' and @name='firstName']")));

		Actions ac = new Actions(driver);

		ac.doubleClick(firstName).perform();

		Thread.sleep(1000);

		firstName.sendKeys(Keys.BACK_SPACE);

		firstName.sendKeys("Vihan");

		Thread.sleep(1000);

		WebElement saveBtn = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@type='submit' and normalize-space()='SAVE']")));

		saveBtn.click();

		Thread.sleep(1500);

		System.out.println("Change Name Executed");

		driver.findElement(By.xpath("//img[@title='Flipkart']")).click();
	}

	@Test(dependsOnMethods = "Change_name")
	public void removeItem() throws InterruptedException {

		driver.findElement(By.xpath("//img[@alt='Cart' and contains(@src,'cart')]")).click();

		WebElement removeBtn = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@dir='auto' and normalize-space()='Remove']")));

		removeBtn.click();

		Thread.sleep(2000);

		System.out.println("Delete Cart Item Executed");
	}

	@AfterTest
	public void afterTest() throws InterruptedException {

		Thread.sleep(3000);

		driver.quit();
	}
}