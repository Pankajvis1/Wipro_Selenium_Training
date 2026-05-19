package WebDriver_Packs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoQATest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/automation-practice-form");

		driver.findElement(By.id("firstName")).sendKeys("Pankaj");

		Thread.sleep(1000);

		driver.findElement(By.id("lastName")).sendKeys("Vishwakarma");

		Thread.sleep(1000);

		driver.findElement(By.id("userEmail")).sendKeys("Pankaj@gmail.com");

		Thread.sleep(1000);
		
		driver.findElement(By.id("gender-radio-1")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("dateOfBirthInput")).click();
		
		Thread.sleep(20000);
		
		WebElement yr=driver.findElement(By.className("react-datepicker_year-select"));
		
		WebElement mt=driver.findElement(By.xpath("//select[@class=\"react-datepicker_month-select\"]"));
		
		Select sel = new Select(yr); 
		
		sel.selectByIndex(100);
		
		Select sel1 = new Select(mt);
		
		sel1.selectByValue("4");
		
		driver. findElement(By.xpath("//*[@id=\"date0fBirth\"]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div[5]/div[4]")).click();
		
		WebElement sub = driver.findElement(By.id("subjectsInput"));

		sub.click();

		sub.sendKeys("Com");

		sub.sendKeys(Keys.ARROW_DOWN);

		sub.sendKeys(Keys.ENTER);

		Thread.sleep(5000);

		driver.quit();
		
		Thread.sleep (3000); 
		
		driver.quit();
	}
}