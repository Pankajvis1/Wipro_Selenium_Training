package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.RegisterPage;
import pages.TransferPage;
import utilities.CSVDataProvider;

public class ParabankTest2 extends BaseTest {

    @Test(priority = 1,
            dataProvider = "parabankData",
            dataProviderClass = CSVDataProvider.class)
    public void completeBankingFlowTest(String firstName,
                                        String lastName,
                                        String address,
                                        String city,
                                        String state,
                                        String zip,
                                        String phone,
                                        String ssn,
                                        String password,
                                        String amount) {

        RegisterPage registerPage = new RegisterPage();
        AccountPage accountPage = new AccountPage();
        TransferPage transferPage = new TransferPage();

        String generatedUsername = "user" + System.currentTimeMillis();

        registerPage.openRegisterPage();

        registerPage.registerUser(
                firstName,
                lastName,
                address,
                city,
                state,
                zip,
                phone,
                ssn,
                generatedUsername,
                password
        );

        Assert.assertTrue(
                registerPage.isRegistrationSuccessful(),
                "Registration failed"
        );

        accountPage.openNewAccountPage();

        accountPage.createSavingsAccount();

        Assert.assertTrue(
                accountPage.isAccountCreated(),
                "Account was not created"
        );

        transferPage.openTransferPage();

        transferPage.transferAmount(amount);

        Assert.assertTrue(
                transferPage.isTransferSuccessful(),
                "Transfer failed"
        );
    }

    @Test(priority = 2)
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage();

        loginPage.login("wrongUser", "wrongPass");

        Assert.assertTrue(
                loginPage.isLoginFailed(),
                "Invalid login validation failed"
        );
    }
}