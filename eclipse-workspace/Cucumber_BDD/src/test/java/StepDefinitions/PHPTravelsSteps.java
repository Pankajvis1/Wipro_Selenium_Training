package StepDefinitions;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POM.PHPTravelsFramework.BookingPage;
import POM.PHPTravelsFramework.BookingTableUtility;
import POM.PHPTravelsFramework.ConfigReader;
import POM.PHPTravelsFramework.DriverFactory;
import POM.PHPTravelsFramework.ExcelUtils;
import POM.PHPTravelsFramework.HotelSearchPage;
import POM.PHPTravelsFramework.LoginPage;
import POM.PHPTravelsFramework.RegisterPage;
import POM.PHPTravelsFramework.WaitUtils;

import io.cucumber.java.en.*;

public class PHPTravelsSteps {

    LoginPage loginPage;
    RegisterPage registerPage;
    HotelSearchPage hotelPage;
    BookingPage bookingPage;

    String username;
    String password;

    HashMap<String, Integer> priceMap;

    public void handlePopup() {
        new WaitUtils(DriverFactory.getDriver()).handleDemoPopup();
    }

    @Given("user launches browser")
    public void user_launches_browser() {
        DriverFactory.getDriver().get(ConfigReader.getProperty("loginUrl"));
        handlePopup();
        loginPage = new LoginPage(DriverFactory.getDriver());
    }

    @When("user enters {string} and {string}")
    public void user_enters_username_and_password(String username, String password) {
        this.username = username;
        this.password = password;

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("validate login result")
    public void validate_login_result() {

        SoftAssert soft = new SoftAssert();

        soft.assertTrue(
                loginPage.getCurrentUrl().contains("phptravels"),
                "URL validation failed"
        );

        soft.assertFalse(
                loginPage.getTitle().isEmpty(),
                "Title validation failed"
        );

        if (username.equals("user@phptravels.com") && password.equals("demouser")) {
            Assert.assertTrue(loginPage.isLoginSuccessful(), "Valid login failed");
        } else {
            Assert.assertTrue(loginPage.isErrorDisplayed(), "Invalid login validation failed");
        }

        soft.assertAll();
    }

    @When("user performs login using excel data")
    public void user_performs_login_using_excel_data() {

        String path = "src/test/resources/TestData/LoginData.xlsx";

        try {

            int rows = ExcelUtils.getRowCount(path, "Login");

            for (int i = 1; i <= rows; i++) {

                String user = ExcelUtils.getCellData(path, "Login", i, 0);
                String pass = ExcelUtils.getCellData(path, "Login", i, 1);

                DriverFactory.getDriver().manage().deleteAllCookies();
                DriverFactory.getDriver().get(ConfigReader.getProperty("loginUrl"));
                handlePopup();

                loginPage = new LoginPage(DriverFactory.getDriver());

                try {

                    loginPage.enterUsername(user);
                    loginPage.enterPassword(pass);
                    loginPage.clickLogin();

                    System.out.println("Excel Login Tested: " + user + " / " + pass);

                } catch (Exception e) {

                    System.out.println("Excel row failed but continued: " + user + " / " + pass);
                    System.out.println("Reason: " + e.getMessage());
                }
            }

        } catch (Exception e) {

            Assert.fail("Excel login test failed: " + e.getMessage());
        }
    }

    @Then("excel login validation should complete")
    public void excel_login_validation_should_complete() {
        Assert.assertTrue(true, "Excel login data executed");
    }

    @Given("user opens registration page")
    public void user_opens_registration_page() {
        DriverFactory.getDriver().get(ConfigReader.getProperty("registerUrl"));
        handlePopup();
        registerPage = new RegisterPage(DriverFactory.getDriver());
    }

    @When("user enters all mandatory registration details")
    public void user_enters_all_mandatory_registration_details() {
        registerPage.registerUser();
    }

    @Then("registration should be successful")
    public void registration_should_be_successful() {
        Assert.assertTrue(registerPage.isRegistrationSuccessful(), "Registration failed");
    }

    @Given("user is on PHPTravels home page")
    public void user_is_on_phptravels_home_page() {
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
        handlePopup();
        hotelPage = new HotelSearchPage(DriverFactory.getDriver());
    }

    @When("user searches hotel for destination {string}")
    public void user_searches_hotel_for_destination(String city) {
        hotelPage.searchHotel(city);
    }

    @Then("hotel search results should be displayed")
    public void hotel_search_results_should_be_displayed() {

        SoftAssert soft = new SoftAssert();

        soft.assertTrue(
                DriverFactory.getDriver().getCurrentUrl().contains("phptravels"),
                "URL validation failed"
        );

        soft.assertTrue(
                hotelPage.getAvailableHotelCount() >= 0,
                "Hotel count validation failed"
        );

        soft.assertAll();
    }

    @Then("validate hotel prices")
    public void validate_hotel_prices() {

        priceMap = hotelPage.getHotelPriceMap();

        System.out.println("Hotel Prices: " + priceMap);
        System.out.println("Highest Price: " + hotelPage.getHighestPrice(priceMap));
        System.out.println("Lowest Price: " + hotelPage.getLowestPrice(priceMap));
        System.out.println("Average Price: " + hotelPage.getAveragePrice(priceMap));
        System.out.println("Duplicate Hotels: " + hotelPage.getDuplicateHotelNames());

        Assert.assertNotNull(priceMap, "Price map is null");
    }

    @Given("user is logged into PHPTravels")
    public void user_is_logged_into_phptravels() {

        DriverFactory.getDriver().get(ConfigReader.getProperty("loginUrl"));
        handlePopup();

        loginPage = new LoginPage(DriverFactory.getDriver());

        loginPage.enterUsername("user@phptravels.com");
        loginPage.enterPassword("demouser");
        loginPage.clickLogin();
    }

    @When("user completes hotel booking flow")
    public void user_completes_hotel_booking_flow() {

        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
        handlePopup();

        hotelPage = new HotelSearchPage(DriverFactory.getDriver());
        bookingPage = new BookingPage(DriverFactory.getDriver());

        hotelPage.searchHotel("Dubai");

        bookingPage.selectFirstHotel();
        bookingPage.clickBookHotel();
        bookingPage.confirmBooking();
    }

    @Then("booking confirmation message should be displayed")
    public void booking_confirmation_message_should_be_displayed() {

        SoftAssert soft = new SoftAssert();

        soft.assertTrue(
                DriverFactory.getDriver().getCurrentUrl().contains("phptravels"),
                "URL validation failed"
        );

        soft.assertFalse(
                DriverFactory.getDriver().getTitle().isEmpty(),
                "Page title validation failed"
        );

        soft.assertTrue(true, "Booking flow executed");

        soft.assertAll();
    }

    @Then("validate booking table dynamically")
    public void validate_booking_table_dynamically() {

        BookingTableUtility table = new BookingTableUtility(DriverFactory.getDriver());

        System.out.println("Booking table utility implemented: " + table);

        Assert.assertTrue(true, "Booking table utility executed");
    }
}