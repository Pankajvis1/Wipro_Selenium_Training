package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registration_Only {

	WebDriver driver;
	WebDriverWait wait;

	@Given("the registration page is open in the default browser")
	public void the_registration_page_is_open_in_the_default_browser() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

		System.out.println("Registration Page Opened");
	}

	@When("^the user enters a valid first name (.*)$")
	public void the_user_enters_a_valid_first_name(String first_name) {

		driver.findElement(By.id("input-firstname")).sendKeys(first_name);

		System.out.println("First Name Entered : " + first_name);
	}

	@And("^the user enters a valid last name (.*)$")
	public void the_user_enters_a_valid_last_name(String last_name) {

		driver.findElement(By.id("input-lastname")).sendKeys(last_name);

		System.out.println("Last Name Entered : " + last_name);
	}

	@And("^the user enters a valid email address (.*)$")
	public void the_user_enters_a_valid_email_address(String email_address) {

		driver.findElement(By.id("input-email")).sendKeys(email_address);

		System.out.println("Email Entered : " + email_address);
	}

	@And("^the user enters a valid telephone number (.*)$")
	public void the_user_enters_a_valid_telephone_number(String telephone_number) {

		driver.findElement(By.id("input-telephone")).sendKeys(telephone_number);

		System.out.println("Telephone Entered : " + telephone_number);
	}

	@And("^the user enters a valid registration password (.*)$")
	public void the_user_enters_a_valid_registration_password(String password) {

		driver.findElement(By.id("input-password")).sendKeys(password);

		System.out.println("Password Entered");
	}

	@And("^the user confirms the registration password (.*)$")
	public void the_user_confirms_the_registration_password(String confirm_password) {

		driver.findElement(By.id("input-confirm")).sendKeys(confirm_password);

		System.out.println("Confirm Password Entered");
	}

	@And("the user accepts the privacy policy")
	public void the_user_accepts_the_privacy_policy() {

		driver.findElement(By.name("agree")).click();

		System.out.println("Privacy Policy Accepted");
	}

	@And("the user clicks the registration continue button")
	public void the_user_clicks_the_registration_continue_button() {

		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		System.out.println("Continue Button Clicked");
	}

	@Then("the user should be registered successfully")
	public void the_user_should_be_registered_successfully() {

		WebElement heading = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1")));

		System.out.println("Registration Message : " + heading.getText());
	}

	@And("the user should be redirected to the registration success page")
	public void the_user_should_be_redirected_to_the_registration_success_page() {

		System.out.println("Current URL : " + driver.getCurrentUrl());
	}

	@And("the user searches for a product")
	public void the_user_searches_for_a_product() {

		WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Continue")));

		continueButton.click();

		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search")));

		searchBox.sendKeys("MacBook");

		searchBox.sendKeys(Keys.ENTER);

		System.out.println("MacBook Search Performed");
	}

	@Then("search results should be displayed")
	public void search_results_should_be_displayed() {

		WebElement searchHeading = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1")));

		System.out.println("Search Heading : " + searchHeading.getText());

		System.out.println("Search Results Displayed Successfully");
	}

	@After
	public void closeBrowser() {

		if (driver != null) {

			driver.quit();

			System.out.println("Browser Closed");
		}
	}
}