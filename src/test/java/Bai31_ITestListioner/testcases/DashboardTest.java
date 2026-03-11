package Bai31_ITestListioner.testcases;


import Bai31_ITestListioner.pages.DashboardPage;
import Bai31_ITestListioner.pages.LoginPage;
import Bai31_ITestListioner.pages.ProjectPage;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DashboardTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ProjectPage projectsPage;

    @Test
    public void testLabelProjectInProgress() {
        loginPage = new LoginPage();
//      loginPage.loginCRM("admin@example.com", "123456");
//      loginPage.verifyLoginSuccess();
//
//      dashboardPage = new DashboardPage(driver);

        dashboardPage = loginPage.loginCRM();

        dashboardPage.verifyDashboardPageDisplayed();

        String totalProjectsInProgressOnDashboard = dashboardPage.getTotalProjectsInProgress();

        projectsPage = dashboardPage.clickMenuProjects(); //Chuyển sang trang Projects

//      projectsPage = new ProjectsPage(driver);

        Assert.assertEquals(totalProjectsInProgressOnDashboard, projectsPage.getTotalProjectsInProgress() + " / " + projectsPage.getTotalProjects(),
                "Total Projects In Progress on Dashboard does not match total Projects In Progress on Projects Page.");

        //dashboardPage.verifyTotalProjectsInProgress();
    }

}
