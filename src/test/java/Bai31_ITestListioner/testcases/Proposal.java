package Bai31_ITestListioner.testcases;


import Bai31_ITestListioner.pages.DashboardPage;
import Bai31_ITestListioner.pages.LoginPage;
import Bai31_ITestListioner.pages.ProposalPage;
import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Proposal extends BaseTest {

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
        proposalPage.clickMenuProposals();
        proposalPage.selectDate("15-2-2021");

    }
}
