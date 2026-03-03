package Bai26_POMWithParallel.pages;

import org.keywords.DriverManager;
import org.openqa.selenium.By;

public class ProjectPage extends BasePage {
    
    private By totalNotStarted = By.xpath("//span[normalize-space()=\"Not Started\"]/parent::div/following-sibling::span");
    private By totalInProgress = By.xpath("//span[normalize-space()=\"In Progress\"]/parent::div/following-sibling::span");
    private By totalFinished = By.xpath("//span[normalize-space()=\"Finished\"]/parent::div/following-sibling::span");
    private By totalOnHold = By.xpath("//span[normalize-space()=\"On Hold\"]/parent::div/following-sibling::span");
    private By totalCancelled = By.xpath("//span[normalize-space()=\"Cancelled\"]/parent::div/following-sibling::span");

     public String getTotalNotStarted() {
        return DriverManager.getDriver().findElement(totalNotStarted).getText();
    }

    public String getTotalInProgress() {
        return DriverManager.getDriver().findElement(totalInProgress).getText();
    }

    public String getTotalFinished() {
        return DriverManager.getDriver().findElement(totalFinished).getText();
    }

    public String getTotalOnHold() {
        return DriverManager.getDriver().findElement(totalOnHold).getText();
    }

    public String getTotalCancelled() {
        return DriverManager.getDriver().findElement(totalCancelled).getText();
    }

    public int getTotalProjects() {
        int totalProjects = Integer.parseInt(getTotalInProgress()) + Integer.parseInt(getTotalNotStarted()) + Integer.parseInt(getTotalFinished()) + Integer.parseInt(getTotalOnHold()) + Integer.parseInt(getTotalCancelled());
        return totalProjects;
    }
}
