package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.CustomerPage;
import pages.LoginPage;
import utilities.DBUtil;

public class BankingTest extends BaseTest {

    @Test(priority = 1)
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage();

        String username = DBUtil.getSingleData(
                "SELECT username FROM login_data WHERE role='manager'",
                "username"
        );

        String password = DBUtil.getSingleData(
                "SELECT password FROM login_data WHERE role='manager'",
                "password"
        );

        loginPage.login(username, password);

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed");
    }

    @Test(priority = 2)
    public void addCustomerTest() {

        LoginPage loginPage = new LoginPage();
        CustomerPage customerPage = new CustomerPage();

        loginPage.login(
                DBUtil.getSingleData("SELECT username FROM login_data WHERE role='manager'", "username"),
                DBUtil.getSingleData("SELECT password FROM login_data WHERE role='manager'", "password")
        );

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed, cannot add customer");

        customerPage.openNewCustomerPage();

        customerPage.addCustomer(
                DBUtil.getSingleData("SELECT name FROM customer_data WHERE id=1", "name"),
                DBUtil.getSingleData("SELECT dob FROM customer_data WHERE id=1", "dob"),
                DBUtil.getSingleData("SELECT address FROM customer_data WHERE id=1", "address"),
                DBUtil.getSingleData("SELECT city FROM customer_data WHERE id=1", "city"),
                DBUtil.getSingleData("SELECT state FROM customer_data WHERE id=1", "state"),
                DBUtil.getSingleData("SELECT pin FROM customer_data WHERE id=1", "pin"),
                DBUtil.getSingleData("SELECT mobile FROM customer_data WHERE id=1", "mobile"),
                DBUtil.getSingleData("SELECT email FROM customer_data WHERE id=1", "email"),
                DBUtil.getSingleData("SELECT password FROM customer_data WHERE id=1", "password")
        );

        if (!customerPage.isCustomerCreated()) {
            String alert = customerPage.getAlertTextAndAccept();
            Assert.fail("Customer was not created. Alert: " + alert);
        }

        String customerId = customerPage.getCustomerId();

        DBUtil.updateData(
                "UPDATE account_data SET customer_id='" + customerId + "' WHERE id=1"
        );

        System.out.println("Generated Customer ID: " + customerId);
    }

    @Test(priority = 3, dependsOnMethods = "addCustomerTest")
    public void createAccountTest() {

        LoginPage loginPage = new LoginPage();
        AccountPage accountPage = new AccountPage();

        loginPage.login(
                DBUtil.getSingleData("SELECT username FROM login_data WHERE role='manager'", "username"),
                DBUtil.getSingleData("SELECT password FROM login_data WHERE role='manager'", "password")
        );

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed, cannot create account");

        accountPage.openNewAccountPage();

        String custId = DBUtil.getSingleData(
                "SELECT customer_id FROM account_data WHERE id=1",
                "customer_id"
        );

        String type = DBUtil.getSingleData(
                "SELECT account_type FROM account_data WHERE id=1",
                "account_type"
        );

        String deposit = DBUtil.getSingleData(
                "SELECT initial_deposit FROM account_data WHERE id=1",
                "initial_deposit"
        );

        accountPage.createAccount(custId, type, deposit);

        if (!accountPage.isAccountCreated()) {
            String alert = accountPage.getAlertTextAndAccept();
            Assert.fail("Account was not created. Alert: " + alert);
        }

        String accountNumber = accountPage.getAccountNumber();

        DBUtil.updateData(
                "UPDATE account_data SET account_number='" + accountNumber + "' WHERE id=1"
        );

        System.out.println("Generated Account Number: " + accountNumber);
    }

    @Test(priority = 4)
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage();

        loginPage.login(
                DBUtil.getSingleData("SELECT username FROM login_data WHERE role='invalid'", "username"),
                DBUtil.getSingleData("SELECT password FROM login_data WHERE role='invalid'", "password")
        );

        String alertText = loginPage.getAlertTextAndAccept();

        Assert.assertTrue(
                alertText.contains("User or Password is not valid"),
                "Invalid login alert was not displayed"
        );
    }

    @Test(priority = 5)
    public void invalidCustomerIdCreateAccountTest() {

        LoginPage loginPage = new LoginPage();
        AccountPage accountPage = new AccountPage();

        loginPage.login(
                DBUtil.getSingleData("SELECT username FROM login_data WHERE role='manager'", "username"),
                DBUtil.getSingleData("SELECT password FROM login_data WHERE role='manager'", "password")
        );

        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed, cannot test invalid customer id");

        accountPage.openNewAccountPage();

        accountPage.createAccount(
                DBUtil.getSingleData("SELECT customer_id FROM invalid_account_data WHERE id=1", "customer_id"),
                DBUtil.getSingleData("SELECT account_type FROM invalid_account_data WHERE id=1", "account_type"),
                DBUtil.getSingleData("SELECT initial_deposit FROM invalid_account_data WHERE id=1", "initial_deposit")
        );

        String alertText = accountPage.getAlertTextAndAccept();

        Assert.assertTrue(
                alertText.toLowerCase().contains("customer") ||
                alertText.toLowerCase().contains("does not exist"),
                "Invalid customer ID alert was not displayed. Actual alert: " + alertText
        );
    }
}