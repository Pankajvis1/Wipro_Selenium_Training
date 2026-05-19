package WebDriver_Packs;

import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonAutomation1 {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		WebElement searchBox = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
		);

		searchBox.sendKeys("Skin care");
		searchBox.sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll down and up
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);

		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(1500);

		// Filter: Discount
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//span[contains(text(),'Today') or contains(text(),'Discount')]")
			)).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Discount filter not found.");
		}

		// Screenshot 1
		TakesScreenshot tc = (TakesScreenshot) driver;
		File sc2 = tc.getScreenshotAs(OutputType.FILE);
		File dest2 = new File("Amazon.png");
		FileHandler.copy(sc2, dest2);

		// Filter: Price
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//span[contains(text(),'₹500') or contains(text(),'₹1,000') or contains(text(),'₹200')]")
			)).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Price filter not found.");
		}

		// Scroll to Brand Filters
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(2000);

		// Filter: Brand 1
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//span[contains(text(),'NIVEA')]")
			)).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("NIVEA brand filter not found.");
		}

		// Filter: Brand 2
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//span[contains(text(),'Himalaya')]")
			)).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Himalaya brand filter not found.");
		}

		// Scroll to Skin Type Filters
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(2000);

		// Filter: Skin Type
		try {
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//span[contains(text(),'Oily') or contains(text(),'Dry') or contains(text(),'Sensitive')]")
			)).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Skin type filter not found.");
		}

		// Screenshot 2
		File sc1 = tc.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("Amazon2.png");
		FileHandler.copy(sc1, dest1);

		Thread.sleep(4000);
		driver.quit();
	}
}