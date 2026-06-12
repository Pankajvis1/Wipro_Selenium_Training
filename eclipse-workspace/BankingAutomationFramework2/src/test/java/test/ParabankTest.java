package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.TransferPage;
import utilities.DBUtil;

public class ParabankTest extends BaseTest {

    @Test(priority = 1)
    public void registerUserTest() {

        RegisterPage registerPage = new RegisterPage();

        String uniqueUsername = "pankaj" + System.currentTimeMillis();

        DBUtil.updateData(
                "UPDATE user_data SET username='" + uniqueUsername + "' WHERE id=1"
        );

        registerPage.openRegisterPage();

        registerPage.registerUser(
                DBUtil.getSingleData("SELECT first_name FROM user_data WHERE id=1", "first_name"),
                DBUtil.getSingleData("SELECT last_name FROM user_data WHERE id=1", "last_name"),
                DBUtil.getSingleData("SELECT address FROM user_data WHERE id=1", "address"),
                DBUtil.getSingleData("SELECT city FROM user_data WHERE id=1", "city"),
                DBUtil.getSingleData("SELECT state FROM user_data WHERE id=1", "state"),
                DBUtil.getSingleData("SELECT zip FROM user_data WHERE id=1", "zip"),
                DBUtil.getSingleData("SELECT phone FROM user_data WHERE id=1", "phone"),
                DBUtil.getSingleData("SELECT ssn FROM user_data WHERE id=1", "ssn"),
                uniqueUsername,
                DBUtil.getSingleData("SELECT password FROM user_data WHERE id=1", "password")
        );

        Assert.assertTrue(registerPage.isRegistrationSuccessful());
    }

    @Test(priority = 2, dependsOnMethods = "registerUserTest")
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage();

        loginPage.login(
                DBUtil.getSingleData("SELECT username FROM user_data WHERE id=1", "username"),
                DBUtil.getSingleData("SELECT password FROM user_data WHERE id=1", "password")
        );

        Assert.assertTrue(loginPage.isLoginSuccessful());
    }

    @Test(priority = 3, dependsOnMethods = "registerUserTest")
    public void openNewAccountTest() {

        LoginPage loginPage = new LoginPage();
        AccountPage accountPage = new AccountPage();

        loginPage.login(
                DBUtil.getSingleData("SELECT username FROM user_data WHERE id=1", "username"),
                DBUtil.getSingleData("SELECT password FROM user_data WHERE id=1", "password")
        );

        accountPage.openNewAccountPage();
        accountPage.createSavingsAccount();

        Assert.assertTrue(accountPage.isAccountCreated());

        System.out.println("New Account Number: " + accountPage.getNewAccountNumber());
    }

    @Test(priority = 4, dependsOnMethods = "registerUserTest")
    public void transferFundsTest() {

        LoginPage loginPage = new LoginPage();
        TransferPage transferPage = new TransferPage();

        loginPage.login(
                DBUtil.getSingleData("SELECT username FROM user_data WHERE id=1", "username"),
                DBUtil.getSingleData("SELECT password FROM user_data WHERE id=1", "password")
        );

        transferPage.openTransferPage();

        transferPage.transferAmount(
                DBUtil.getSingleData("SELECT amount FROM transfer_data WHERE id=1", "amount")
        );

        Assert.assertTrue(transferPage.isTransferSuccessful());
    }

    @Test(priority = 5)
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage();

        loginPage.login("wrongUser", "wrongPass");

        Assert.assertTrue(loginPage.isLoginFailed());
    }
}