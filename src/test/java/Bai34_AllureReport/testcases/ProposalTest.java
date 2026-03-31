package Bai34_AllureReport.testcases;


import Bai34_AllureReport.pages.DashboardPage;
import Bai34_AllureReport.pages.LoginPage;
import Bai34_AllureReport.pages.ProposalPage;
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
