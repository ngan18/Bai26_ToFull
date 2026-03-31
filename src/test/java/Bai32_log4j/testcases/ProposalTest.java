package Bai32_log4j.testcases;


import Bai32_log4j.pages.DashboardPage;
import Bai32_log4j.pages.LoginPage;
import Bai32_log4j.pages.ProposalPage;
import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ProposalTest extends BaseTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProposalPage proposalPage;
    private DashboardPage dashboardPages;

    @Test
    public void testProposal() {

        loginPage = new LoginPage();
        dashboardPages = loginPage.loginCRM();
        loginPage.verifyLoginSuccess();

        proposalPage = new ProposalPage();
        proposalPage.clickMenuProposal();
        proposalPage.selectDate("15-2-2021");

    }
}
