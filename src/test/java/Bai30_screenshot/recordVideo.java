package Bai30_screenshot;

import Bai30_screenshot.pages.CustomerPage;
import Bai30_screenshot.pages.DashboardPage;
import Bai30_screenshot.pages.LoginPage;
import common.BaseTest;
import org.Helpers.CaptureHelper;
import org.Helpers.PropertiesHelper;
import org.keywords.DriverManager;
import org.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class recordVideo extends BaseTest {

    @Test
    public void testVideoRecord(Method method) {
        CaptureHelper.startRecord(method.getName());

        LoginPage loginPage = new LoginPage();

        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLeadsOverview(Method method) {
        CaptureHelper.startRecord(method.getName());

        LoginPage loginPage;
        DashboardPage dashboardPage;
        CustomerPage customersPage;

        loginPage = new LoginPage();
        loginPage.loginCRM();
        WebUI.clickElement(By.xpath("//span[@class='menu-text'][normalize-space()='Leads']"));
        WebUI.waitForPageLoaded();
        WebUI.clickElement(By.xpath("//i[@class='fa fa-bar-chart']"));
        //WebUI.waitForPageLoaded();
        //WebUI.checkElementExist(By.xpath("//span[normalize-space()='Active']/preceding-sibling::span"), 5, 1000);
        String labelActiveValue = WebUI.getElementText(By.xpath("//span[normalize-space()='Active']/preceding-sibling::span"));
        Assert.assertEquals(labelActiveValue, "13", "Active leads count does not match expected value.");
        String labelCutsomerValue = WebUI.getElementText(By.xpath("//span[normalize-space()='Customer']/preceding-sibling::span"));
        Assert.assertEquals(labelCutsomerValue, "4", "Customer leads count does not match expected value.");

        //Set data to properties file
        PropertiesHelper.setValue("leads_active", labelActiveValue);
        PropertiesHelper.setValue("leads_customer", labelCutsomerValue);

    }

}
