package Bai30_screenshot.pages;

import org.keywords.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardPage extends BasePage {
   

    private By buttonDashboardOptions = By.xpath("//button[@data-toggle=\"dropdown\"]");
    private By totalLabelProjectsInProgress = By.xpath("//div[contains(@class, 'card-body')]//h5[normalize-space()=\"Projects in Progress\"]/following-sibling::p");

    //khai báo hàm xử lí trong nội bộ dashboard
    public void verifyDashboardPageDisplayed() {
        boolean isDashboardDisplayed = DriverManager.getDriver().findElements(By.xpath("//span[normalize-space()=\"Dashboard\"]")).size() > 0;
        Assert.assertTrue(isDashboardDisplayed, "Not on dashboard page");
    }

    public String verifyTotalProjectsInProgress() {

        String totalProjectsOnDashboard =DriverManager.getDriver().findElement(totalLabelProjectsInProgress).getText();
        System.out.println("Total Projects in Progress: " + totalProjectsOnDashboard);

        clickMenuProjects();
        // Thực hiện các bước để lấy tổng số dự án từ các trạng thái khác nhau

        ProjectPage projectPage = new ProjectPage();

        Assert.assertEquals(totalProjectsOnDashboard, projectPage.getTotalInProgress()+"/"+projectPage.getTotalProjects(),"failed");
        return totalProjectsOnDashboard;
    }


}

