package Bai34_AllureReport.pages;

import org.keywords.WebUI;
import org.openqa.selenium.By;

public class ProposalPage extends BasePage {

    private LoginPage loginPage;

    private By buttonDate = By.xpath("//input[@id=\"date\"]");
    private By monthDropdown = By.xpath("//select[@class='ui-datepicker-month']");
    private By yearDropdown = By.xpath("//select[@class='ui-datepicker-year']");
    private By dayOption = By.xpath("//a[text()='15']");


    // select date month year
    public void selectDate(String date) {
        String[] dateParts = date.split("-");
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];

        // Click vào trường ngày để mở calendar
        WebUI.clickElement( buttonDate);

        // Chọn năm
        WebUI.clickElement(yearDropdown);

        // Chọn tháng
        WebUI.clickElement( monthDropdown);

        // Chọn ngày
        WebUI.clickElement(dayOption);
    }

}
