package Bai34_AllureReport.testcases;

import Bai34_AllureReport.pages.CustomerPage;
import Bai34_AllureReport.pages.DashboardPage;
import Bai34_AllureReport.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private CustomerPage customersPage;

    @Test
    public void testAddNewCustomer() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        customersPage = dashboardPage.clickMenuCustomers();
        customersPage.verifyCustomerPageDisplayed();
        customersPage.clickAddNewCustomerButton();
        customersPage.fillDataNewCustomer("Test Customer 1808A1", "VIP", "USD", "Vietnamese", "Vietnam");
        customersPage.clickSaveButton();
        customersPage.verifyAlertMessageSuccessDisplayed();
        customersPage.verifyCustomerDetail("Test Customer 1808A1", "VIP", "USD", "Vietnamese", "Vietnam");
    }

}
