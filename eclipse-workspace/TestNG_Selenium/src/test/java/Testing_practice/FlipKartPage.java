package Testing_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipKartPage {

    WebDriver driver;
    POM_Flipkart fp;

    String mobileNo = "7275656529";
    String productName = "Apple Laptop";
    String newName = "Vihan";

    @BeforeTest
    public void beforeTest() throws InterruptedException {

        driver = new ChromeDriver();

        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        fp = new POM_Flipkart(driver);

        Thread.sleep(3000);

        fp.closePopup();
    }

    @Test
    public void login() throws InterruptedException {
        fp.login(mobileNo);
        System.out.println("Login Test Executed");
    }

    @Test(dependsOnMethods = "login")
    public void multiple_search() throws InterruptedException {
        fp.searchProduct("iphone");
        fp.searchProduct("ipad");
        fp.searchProduct("macbook");

        System.out.println("Multiple Search Executed");
    }

    @Test(dependsOnMethods = "multiple_search")
    public void view_product_details() throws InterruptedException {
        driver.get("https://www.flipkart.com/");
        fp.closePopup();

        fp.viewProductDetails(productName);

        System.out.println("Viewed Product Details");
    }

    @Test(dependsOnMethods = "view_product_details")
    public void add_to_cart() throws InterruptedException {
        driver.get("https://www.flipkart.com/");
        fp.closePopup();

        fp.addToCart(productName);

        System.out.println("Product Added To Cart");
    }

    @Test(dependsOnMethods = "add_to_cart")
    public void change_Address() throws InterruptedException {
        fp.changeAddress();

        System.out.println("Change Address Executed");
    }

    @Test(dependsOnMethods = "change_Address")
    public void Change_name() throws InterruptedException {
        fp.changeName(newName);

        System.out.println("Change Name Executed");
    }

    @Test(dependsOnMethods = "Change_name")
    public void removeItem() throws InterruptedException {
        fp.removeItem();

        System.out.println("Delete Cart Item Executed");
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}