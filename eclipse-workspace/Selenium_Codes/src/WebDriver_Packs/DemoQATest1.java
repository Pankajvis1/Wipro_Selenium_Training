package WebDriver_Packs;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class DemoQATest1 {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/automation-practice-form");
	

		Thread.sleep(3000);

		driver.findElement(By.id("firstName")).sendKeys("Pankaj");

		driver.findElement(By.id("lastName")).sendKeys("Vishwakarma");

		driver.findElement(By.id("userEmail")).sendKeys("Pankaj@gmail.com");

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,900)");
		
		// Gender radio button
		driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();

		Thread.sleep(1000);
		
		driver.findElement(By.id("userNumber")).sendKeys("7357253728");

		// Open Date Picker
		driver.findElement(By.id("dateOfBirthInput")).click();

		Thread.sleep(1000);

		// Select Month
		WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
		Select selectMonth = new Select(month);
		selectMonth.selectByValue("3");
		
		Thread.sleep(1000);

		// Select Year
		WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
		Select selectYear = new Select(year);
		selectYear.selectByValue("2000");

		Thread.sleep(1000);
		
		// Select Date
		driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div[3]/div[3]")).click();

		Thread.sleep(1000);
		
		WebElement sub = driver.findElement(By.id("subjectsInput"));

		sub.click();

		sub.sendKeys("Com");

		sub.sendKeys(Keys.ARROW_DOWN);

		sub.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();

		driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();

		driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']")).click();

		WebElement upload = driver.findElement(By.id("uploadPicture"));

		upload.sendKeys("/Users/pankajvishwakarma/Desktop/Screenshot 2026-05-16 at 12.12.29 PM.png");

		driver.findElement(By.id("currentAddress")).sendKeys("SuperTech Capetown");

		Actions act = new Actions(driver);

		driver.findElement(By.id("currentAddress")).sendKeys(Keys.PAGE_DOWN);

		Thread.sleep(1000);

		act.moveToElement(driver.findElement(By.xpath("//div[text()='Select State']"))).click().perform();

		driver.findElement(By.id("react-select-3-input")).sendKeys("NCR");

		driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);

		act.moveToElement(driver.findElement(By.xpath("//div[text()='Select City']"))).click().perform();

		driver.findElement(By.id("react-select-4-input")).sendKeys("Noida");

		driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);

		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0,-900)");
		
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,900)");
		
		Thread.sleep(1000);

		driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
		
		TakesScreenshot tc = (TakesScreenshot)driver;
		
		File sc = tc.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("DemoQAform.png");
		
		FileHandler.copy(sc, dest);

		Thread.sleep(4000);
		
		driver.quit();
	}
}