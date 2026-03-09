package Bai29_DataProvider;

import Bai27_PropertiesFile.pages.CustomerPage;
import Bai27_PropertiesFile.pages.DashboardPage;
import Bai27_PropertiesFile.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class demoDataProviderHardcode extends BaseTest {

    @Test(dataProvider = "loginData1", dataProviderClass = demoDataProvider.class)
    public void testLogin1(String email, int password) {
        System.out.println("Email: " + email + " | Password: " + password);
    }

    @Test(dataProvider = "loginData2", dataProviderClass = demoDataProvider.class)
    public void testLogin2(String email, int password, String role) {
        System.out.println("Email: " + email + " | Password: " + password + " | Role: " + role);
    }

    @Test(dataProvider = "loginData2", dataProviderClass = demoDataProvider.class)
    public void testLoginCRM(String email, int password, String role) {
        System.out.println("Email: " + email + " | Password: " + password + " | Role: " + role);
        LoginPage loginPage = new LoginPage();
        loginPage.loginCRM(email, String.valueOf(password));
        loginPage.verifyLoginSuccess();
    }

    @Test(dataProvider = "AddNewCustomerData",dataProviderClass = demoDataProvider.class)
    public void testAddNewCustomer(String customerName, String group, String currency, String language, String country) {
        LoginPage loginPage;
        DashboardPage dashboardPage;
        CustomerPage customersPage;

        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomerPageDisplayed();
        customersPage.clickAddNewCustomerButton();
        customersPage.fillDataNewCustomer(customerName, group, currency, language, country);
        customersPage.clickSaveButton();
        customersPage.verifyAlertMessageSuccessDisplayed();
        customersPage.verifyCustomerDetail(customerName, group, currency, language, country);
    }

}
