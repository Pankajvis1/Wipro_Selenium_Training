package Testing_practice;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class EbayTest {

	WebDriver driver;
	Ebay_POM ebay;

	@BeforeClass(alwaysRun = true)
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		ebay = new Ebay_POM(driver);
	}

	@DataProvider(name = "registrationData")
	public Object[][] registrationData() {

		return new Object[][] { { "Pankaj", "Vishwakarma", "royalraezor@gmail.com", "Test@12345" } };
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
	public void registrationTest(String fname, String lname, String email, String password) throws Exception {

		ebay.openRegistrationPage();
		ebay.registerUser(fname, lname, email, password);

		System.out.println("Registration Test Executed");
	}

	@Test(priority = 2, dependsOnMethods = "registrationTest", groups = { "smoke", "regression" })
	public void loginTest() throws Exception {

		ebay.openLoginPage();
		ebay.loginUser("royalraezor@gmail.com");

		System.out.println("Login Test Executed");
	}

	@Test(priority = 3, dataProvider = "searchData", dependsOnMethods = "loginTest", groups = { "smoke", "regression" })
	public void searchProductTest(String product) throws Exception {

		ebay.searchProduct(product);

		System.out.println("Searched Product: " + product);
	}

	@Test(priority = 4, dependsOnMethods = "searchProductTest", groups = { "smoke", "regression" })
	public void addToCartTest() throws Exception {

		ebay.addProductToCart();

		System.out.println("Add To Cart Test Executed");
	}

	@Test(priority = 5, dependsOnMethods = "addToCartTest", groups = { "regression" })
	public void removeProductTest() throws Exception {

		ebay.removeProduct();

		System.out.println("Remove Product Test Executed");
	}

	@Test(priority = 6, dependsOnMethods = "addToCartTest", groups = { "regression" })
	public void checkoutTest() throws Exception {

		ebay.checkout();

		System.out.println("Checkout Test Executed");
	}

	@Test(priority = 7, dependsOnMethods = "checkoutTest", groups = { "regression" })
	public void orderConfirmationTest() throws Exception {

		ebay.verifyOrderConfirmation();

		System.out.println("Order Confirmation Test Executed");
	}

	@Test(priority = 8, dependsOnMethods = "orderConfirmationTest", groups = { "smoke", "regression" })
	public void logoutTest() throws Exception {

		ebay.logout();

		System.out.println("Logout Test Executed");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}
}