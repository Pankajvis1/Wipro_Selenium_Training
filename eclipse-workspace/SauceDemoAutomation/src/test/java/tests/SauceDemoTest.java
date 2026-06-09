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

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(productsPage.getPageTitle(), "Products");

        ScreenshotUtil.takeScreenshot(driver, "ValidLogin");
    }

    @Test(priority = 2)
    public void addProductToCartTest() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.addProductToCart();
        productsPage.goToCart();

        Assert.assertEquals(cartPage.getCartItemName(), "Sauce Labs Backpack");

        ScreenshotUtil.takeScreenshot(driver, "ProductAddedToCart");
    }

    @Test(priority = 3)
    public void completeCheckoutTest() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.addProductToCart();
        productsPage.goToCart();

        cartPage.clickCheckout();

        checkoutPage.enterCheckoutDetails("Pankaj", "Vishwakarma", "208001");
        checkoutPage.finishCheckout();

        Assert.assertEquals(checkoutPage.getSuccessMessage(), "Thank you for your order!");

        ScreenshotUtil.takeScreenshot(driver, "CheckoutCompleted");
    }
}