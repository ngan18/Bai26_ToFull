package Bai27_PropertiesFile.testcases;


import Bai27_PropertiesFile.pages.DashboardPage;
import Bai27_PropertiesFile.pages.LoginPage;
import Bai27_PropertiesFile.pages.ProposalPage;
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
