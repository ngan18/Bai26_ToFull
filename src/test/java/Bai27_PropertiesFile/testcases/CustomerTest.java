package Bai27_PropertiesFile.testcases;

import Bai27_PropertiesFile.pages.CustomerPage;
import Bai27_PropertiesFile.pages.DashboardPage;
import Bai27_PropertiesFile.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    private LoginPage loginPaget;
    private CustomerPage customerPage;
    private DashboardPage dashboardPage;

    @Test
     public void testAddNewCustomer() throws InterruptedException {
        loginPaget = new LoginPage();
        dashboardPage = loginPaget.loginCRM();

        customerPage = new CustomerPage();

        dashboardPage.clickMenuCustomers();
        customerPage.verifyCustomerPageDisplayed();
        customerPage.clickAddNewCustomerButton();
        customerPage.fillDataNewCustomer("John Doe", "A1", "USD", "Vietnamese", "Vietnam");

        customerPage.clickSaveButton();
        customerPage.verifyAlertMessageSuccessDisplayed();

        customerPage.verifyCustomerDetail("John Doe", "A1", "USD", "Vietnamese", "Vietnam");

    }

}
