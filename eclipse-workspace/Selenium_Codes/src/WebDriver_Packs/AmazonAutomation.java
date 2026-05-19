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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonAutomation {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("https://www.amazon.in/");
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")))
				.sendKeys("Skin care");

		Thread.sleep(1000);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Filter:1 For Men

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"filter-\"]/span/span[1]/li/span/a/span"))).click();

		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(2000);

		// Filter:2 Discount

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"p_n_deal_type/26921226031\"]/span/a/span"))).click();

		TakesScreenshot tc = (TakesScreenshot) driver;

		File sc2 = tc.getScreenshotAs(OutputType.FILE);

		File dest2 = new File("Amazon.png");

		FileHandler.copy(sc2, dest2);

		Thread.sleep(1500);

		// Filter:3 Price

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"p_36/dynamic-picker-2\"]/span/a/span"))).click();

		Thread.sleep(1500);

		driver.navigate().to("https://www.amazon.in/s?k=skin+care+kit+for+men&rh=p_n_deal_type%3A26921226031%2Cp_36%3A50000-80000&dc&qid=1779088729&rnid=1741387031&ref=sr_nr_p_36_3&ds=v1%3AeQ4zGulW%2FAC637XGbrgHQcxj54cdAxrLxCOLTBXcFGA");
		// Filter:4 CheckBox

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"p_123/174303\"]/span/a/span"))).click();

		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"p_123/222572\"]/span/a/span"))).click();

		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"p_123/235048\"]/span/a/span"))).click();

		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"p_123/964140\"]/span/a/span"))).click();

		Thread.sleep(1000);

		// Filter:5 Skin Type

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"p_n_g-101015171052111/93769512031\"]/span/a/span"))).click();

		Thread.sleep(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"p_n_g-101015171052111/93769516031\"]/span/a/span"))).click();

		Thread.sleep(1000);

		// Screenshot

		File sc1 = tc.getScreenshotAs(OutputType.FILE);

		File dest1 = new File("Amazon2.png");

		FileHandler.copy(sc1, dest1);

		Thread.sleep(4000);

		driver.quit();
	}
}