package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.ScreenshotUtil;

public class SauceDemoTest extends BaseTest {

    @Test(priority = 1)
    public void validLoginTest() {

        log.info("Starting valid login test");

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(
                productsPage.getPageTitle(),
                "Products");

        ScreenshotUtil.takeScreenshot(driver, "ValidLogin");

        log.info("Valid login test completed");
    }

    @Test(priority = 2)
    public void addProductToCartTest() {

        log.info("Starting add product to cart test");

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.addProductToCart();
        productsPage.goToCart();

        Assert.assertEquals(
                cartPage.getCartItemName(),
                "Sauce Labs Backpack");

        ScreenshotUtil.takeScreenshot(driver, "ProductAddedToCart");

        log.info("Add product to cart test completed");
    }

    @Test(priority = 3)
    public void completeCheckoutTest() {

        log.info("Starting complete checkout test");

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.addProductToCart();
        productsPage.goToCart();

        cartPage.clickCheckout();

        checkoutPage.enterCheckoutDetails(
                "Pankaj",
                "Vishwakarma",
                "208001");

        checkoutPage.finishCheckout();

        Assert.assertEquals(
                checkoutPage.getSuccessMessage(),
                "Thank you for your order!");

        ScreenshotUtil.takeScreenshot(driver, "CheckoutCompleted");

        log.info("Complete checkout test completed");
    }
}