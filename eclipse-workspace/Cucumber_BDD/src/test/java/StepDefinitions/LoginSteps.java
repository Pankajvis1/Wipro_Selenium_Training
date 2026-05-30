package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class LoginSteps {

	WebDriver driver;

	@Given("the login page is open in the default browser")
	public void the_login_page_is_open_in_the_default_browser() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("http://zero.webappsecurity.com/login.html");
	}

	@When("the user enters username {string}")
	public void the_user_enters_username(String username1) {

		driver.findElement(By.id("user_login")).sendKeys(username1);
	}

	@And("the user enters password {string}")
	public void the_user_enters_password(String password1) {

		driver.findElement(By.id("user_password")).sendKeys(password1);
	}

	@And("the user clicks the submit button with status {string}")
	public void the_user_clicks_the_submit_button_with_status(String status) {

		driver.findElement(By.name("submit")).click();

		System.out.println("Test case Status = " + status);
	}

	@Then("verify login result {string}")
	public void verify_login_result(String status) throws InterruptedException {

		Thread.sleep(2000);

		String currentUrl = driver.getCurrentUrl();

		System.out.println("Current URL = " + currentUrl);

		if (status.equalsIgnoreCase("success")) {

			Assert.assertFalse(currentUrl.contains("login"), "Login should be successful but failed");

		} else if (status.equalsIgnoreCase("fail")) {

			Assert.assertTrue(currentUrl.contains("login"), "Login should fail but passed");
		}
	}

	@After
	public void closeBrowser() {

		if (driver != null) {
			driver.quit();
		}
	}
}