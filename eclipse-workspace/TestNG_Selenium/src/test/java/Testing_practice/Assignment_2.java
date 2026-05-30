package Testing_practice;

import org.testng.annotations.Test;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;


public class Assignment_2 {

	WebDriver driver;

	@DataProvider(name = "userData")
	public Object[][] userData() {

		return new Object[][] {
			{ "Aman", "Singh", "aman1@gmail.com", "9876543210" },
			{ "Rahul", "Sharma", "rahul@gmail.com", "9876543211" },
			{ "Amit", "Verma", "amit@gmail.com", "9876543212" },
			{ "Rohit", "Singh", "rohit@gmail.com", "9876543213" },
			{ "Neha", "Gupta", "neha@gmail.com", "9876543214" }
		};
	}

	@Test(dataProvider = "userData")
	public void registerUser(String firstName, String lastName, String email, String mobile)
			throws InterruptedException {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts()
		.implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://demoqa.com/automation-practice-form");

		driver.findElement(By.id("firstName")).sendKeys(firstName);

		driver.findElement(By.id("lastName")).sendKeys(lastName);

		driver.findElement(By.id("userEmail")).sendKeys(email);

		driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();

		driver.findElement(By.id("userNumber")).sendKeys(mobile);

		Thread.sleep(3000);

		driver.quit();
	}
}