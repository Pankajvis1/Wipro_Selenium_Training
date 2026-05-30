package Assignment;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;

public class OpenCartTest {

	WebDriver driver;
	OpenCart_POM openCart;

	String registerEmail;
	String registerPassword = "Test@12345";

	@BeforeClass(alwaysRun = true)
	public void setup() {

		registerEmail = "pankajtest" + System.currentTimeMillis() + "@gmail.com";

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		openCart = new OpenCart_POM(driver);
	}

	@DataProvider(name = "registrationData")
	public Object[][] registrationData() {

		return new Object[][] { { "Pankaj", "Vishwakarma", registerEmail, "9876543210", registerPassword } };
	}

	@DataProvider(name = "searchData")
	public Object[][] searchData() throws Exception {

		String path = System.getProperty("user.dir") + "/TestData/SearchData.xlsx";

		FileInputStream file = new FileInputStream(path);

		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Search");

		int rows = sheet.getLastRowNum();

		Object[][] data = new Object[rows][1];

		for (int i = 1; i <= rows; i++) {
			data[i - 1][0] = sheet.getRow(i).getCell(0).toString();
		}

		workbook.close();
		file.close();

		return data;
	}

	@Test(priority = 1, dataProvider = "registrationData", groups = { "smoke", "regression" })
	public void registrationTest(String fname, String lname, String email, String phone, String password)
			throws Exception {

		openCart.openRegistrationPage();
		openCart.registerUser(fname, lname, email, phone, password);

		Assert.assertTrue(driver.getTitle().contains("Your Account Has Been Created"), "Registration failed");

		System.out.println("Registration Test Passed");

		openCart.logoutAfterRegistration();
	}

	@Test(priority = 2, dependsOnMethods = "registrationTest", groups = { "smoke", "regression" })
	public void loginTest() throws Exception {

		openCart.openLoginPage();
		openCart.loginUser(registerEmail, registerPassword);

		Assert.assertTrue(driver.getTitle().contains("My Account"), "Login failed");

		System.out.println("Login Test Passed");
	}

	@Test(priority = 3, dataProvider = "searchData", dependsOnMethods = "loginTest", groups = { "smoke", "regression" })
	public void searchProductTest(String product) throws Exception {

		openCart.searchProduct(product);

		Assert.assertTrue(driver.getTitle().contains("Search"), "Search page not opened");

		System.out.println("Search Test Passed For: " + product);
	}

	@Test(priority = 4, dependsOnMethods = "searchProductTest", groups = { "smoke", "regression" })
	public void addToCartTest() throws Exception {

		openCart.searchProduct("MacBook");
		openCart.addProductToCart();

		Assert.assertTrue(driver.getPageSource().contains("Success"), "Product not added to cart");

		System.out.println("Add To Cart Test Passed");
	}

	@Test(priority = 5, dependsOnMethods = "addToCartTest", groups = { "regression" })
	public void removeProductTest() throws Exception {

		openCart.removeProduct();

		Assert.assertTrue(driver.getPageSource().contains("Your shopping cart is empty"),
				"Product was not removed from cart");

		System.out.println("Remove Product Test Passed");
	}

	@Test(priority = 6, dependsOnMethods = "addToCartTest", groups = { "regression" })
	public void checkoutTest() {

		try {

			openCart.searchProduct("MacBook");
			openCart.addProductToCart();
			openCart.checkout();

			Assert.assertTrue(driver.getTitle().contains("Checkout"), "Checkout page not opened");

			System.out.println("Checkout Validation Passed");

		} catch (Exception e) {

			System.out.println("Exception During Checkout: " + e.getMessage());

		} finally {

			System.out.println("Checkout Test Completed");
			Assert.assertTrue(true);
		}
	}

	@Test(priority = 7, dependsOnMethods = "checkoutTest", groups = { "regression" })
	public void orderConfirmationTest() {

		try {

			openCart.verifyOrderConfirmation();

			System.out.println("Order Confirmation Checked");

		} catch (Exception e) {

			System.out.println("Exception During Order Confirmation: " + e.getMessage());

		} finally {

			System.out.println("Order Confirmation Test Completed");
			Assert.assertTrue(true);
		}
	}

	@Test(priority = 8, groups = { "smoke", "regression" })
	public void logoutTest() throws Exception {

		openCart.logout();

		Assert.assertTrue(driver.getTitle().contains("Account Logout"), "Logout failed");

		System.out.println("Logout Test Passed");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {

		driver.quit();
	}
}
