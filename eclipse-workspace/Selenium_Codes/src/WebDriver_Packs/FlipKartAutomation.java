package WebDriver_Packs;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipKartAutomation {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html/body/div[5]/div/span")).click();
		
		//Login
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div[2]/div/div/div/div/div/header/div[2]/div[2]/div/div/div[1]/div/a/span")).click();
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[1]/input")).sendKeys("7300293160");
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement loginButton = wait.until(
		        
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"container\"]/div/div[3]/div/div[2]/div/form/div[3]/button")));

		loginButton.click();

		Thread.sleep(15000);

		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

		searchBox.sendKeys("Apple Laptop");
		searchBox.sendKeys(Keys.ENTER);

		Thread.sleep(4000);

		WebElement product = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div[3]/div/a[2]")));

		product.click();

		Thread.sleep(2000);

		product.click();

		Thread.sleep(2000);
		
		// Switch to New Tab
		for (String window : driver.getWindowHandles()) {
			driver.switchTo().window(window);
		}

		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement laptopImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@src,'rukminim')])[1]")));
		js.executeScript("arguments[0].click();", laptopImage);

		Thread.sleep(3000);

		driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div/div[1]/div/div[2]/div/div[21]/div/div/div/div/div/div/div/div/div/div[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div/div[1]/div[1]/div/header/div[3]/div[4]/div/a")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"slot-list-container\"]/div/div[1]/div/div/div/div/div/div[2]/div/div[3]/div/div/div/div[1]/div/div[1]/div/div")).click();
		
		Thread.sleep(4000);
		
		TakesScreenshot tc = (TakesScreenshot)driver;
		File sc = tc.getScreenshotAs(OutputType.FILE);
		File dest = new File("Flipkart.png");
		FileHandler.copy(sc, dest);
		
		driver.quit();
		
	}

}

//Verify login with valid credentials |
//Search with valid keyword (e.g.,"laptop")
//Verify product title, price,
//and rating displayed
//Verify image zoom functionality
//Verify "Add to Cart" button visibility
//Verify "buy" button visibility
//Verify "checkout" button visibility