package Bai31_ITestListioner.pages;

import org.keywords.DriverManager;
import org.openqa.selenium.By;

;

public class BasePage {


    
    private By menuDashboard = By.xpath("//span[normalize-space()=\"Dashboard\"]");
    private By menuProjects = By.xpath("//span[normalize-space()=\"Projects\"]");
    private By menuCustomers = By.xpath("//span[normalize-space()=\"Customers\"]");
    private By menuTasks = By.xpath("//span[normalize-space()=\"Tasks\"]");
    private By menuProposals = By.xpath("//span[normalize-space()=\"Proposals\"]");

    // Hàm để click vào menu Dashboard
    public void clickMenuDashboard() {

        DriverManager.getDriver().findElement(menuDashboard).click();
    }

    // Hàm để click vào menu Projects
    public ProjectPage clickMenuProjects() {
        DriverManager.getDriver().findElement(menuProjects).click();
        return new ProjectPage();
    }

    // Hàm để click vào menu Customers
    public CustomerPage clickMenuCustomers() {
        DriverManager.getDriver().findElement(menuCustomers).click();
        return new CustomerPage();

    }

    //Hàm click vào menu Tasks
    public void clickMenuTasks() {
        By menuTasks = By.xpath("//span[normalize-space()=\"Tasks\"]");
        DriverManager.getDriver().findElement(menuTasks).click();
        //return new TaskPage(DriverManager.getDriver()

    }
    //Click vào menu Proposals
    public void clickMenuProposals() {
        DriverManager.getDriver().findElement(menuProposals).click();
        //return new Proposal(DriverManager.getDriver()

    }
}
