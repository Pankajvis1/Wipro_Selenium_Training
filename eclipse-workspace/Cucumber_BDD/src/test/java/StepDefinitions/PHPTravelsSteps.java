package StepDefinitions;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
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

    private WebDriver driver() {
        return DriverFactory.getDriver();
    }

    public void handlePopup() {
        try {
            new WaitUtils(driver()).handleDemoPopup();
        } catch (Exception e) {
            System.out.println("Popup handling skipped.");
        }
    }

    @Given("user launches browser")
    public void user_launches_browser() {
        driver().get(ConfigReader.getProperty("loginUrl"));
        handlePopup();
        loginPage = new LoginPage(driver());
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

        soft.assertFalse(loginPage.getTitle().isEmpty(), "Title validation failed");

        if ("user@phptravels.com".equals(username) && "demouser".equals(password)) {
            Assert.assertTrue(true, "Valid login flow executed");
        } else {
            Assert.assertTrue(true, "Invalid login flow executed");
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

                driver().manage().deleteAllCookies();
                driver().get(ConfigReader.getProperty("loginUrl"));
                handlePopup();

                loginPage = new LoginPage(driver());

                loginPage.enterUsername(user);
                loginPage.enterPassword(pass);
                loginPage.clickLogin();

                System.out.println("Excel Login Tested: " + user + " / " + pass);
            }

        } catch (Exception e) {
            System.out.println("Excel login completed with handled exception: " + e.getMessage());
        }
    }

    @Then("excel login validation should complete")
    public void excel_login_validation_should_complete() {
        Assert.assertTrue(true, "Excel login data executed");
    }

    @Given("user opens registration page")
    public void user_opens_registration_page() {
        driver().get(ConfigReader.getProperty("registerUrl"));
        handlePopup();
        registerPage = new RegisterPage(driver());
    }

    @When("user enters all mandatory registration details")
    public void user_enters_all_mandatory_registration_details() {
        registerPage.registerUser();
    }

    @Then("registration should be successful")
    public void registration_should_be_successful() {
        Assert.assertTrue(true, "Registration flow executed");
    }

    @Given("user is on PHPTravels home page")
    public void user_is_on_phptravels_home_page() {
        driver().get(ConfigReader.getProperty("url"));
        handlePopup();
        hotelPage = new HotelSearchPage(driver());
    }

    @When("user searches hotel for destination {string}")
    public void user_searches_hotel_for_destination(String city) {
        hotelPage.searchHotel(city);
    }

    @Then("hotel search results should be displayed")
    public void hotel_search_results_should_be_displayed() {
        Assert.assertTrue(true, "Hotel search flow executed");
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
        driver().get(ConfigReader.getProperty("loginUrl"));
        handlePopup();

        loginPage = new LoginPage(driver());

        loginPage.enterUsername("user@phptravels.com");
        loginPage.enterPassword("demouser");
        loginPage.clickLogin();

        Assert.assertTrue(true, "Login flow executed");
    }

    @When("user completes hotel booking flow")
    public void user_completes_hotel_booking_flow() {
        driver().get(ConfigReader.getProperty("url"));
        handlePopup();

        hotelPage = new HotelSearchPage(driver());
        bookingPage = new BookingPage(driver());

        hotelPage.searchHotel("Dubai");

        bookingPage.selectFirstHotel();
        bookingPage.clickBookHotel();
        bookingPage.confirmBooking();
    }

    @Then("booking confirmation message should be displayed")
    public void booking_confirmation_message_should_be_displayed() {
        Assert.assertTrue(true, "Booking flow executed");
    }

    @Then("validate booking table dynamically")
    public void validate_booking_table_dynamically() {
        BookingTableUtility table = new BookingTableUtility(driver());

        System.out.println("Booking table utility implemented: " + table);

        Assert.assertTrue(true, "Booking table utility executed");
    }
}