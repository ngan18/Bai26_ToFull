package Bai30_screenshot.pages;

import org.keywords.DriverManager;
import org.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

@SuppressWarnings("ALL")
public class CustomerPage extends BasePage {


    // Locators for Customers Summary Page
    private By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By buttonAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By buttonImportCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By inputSearchCustomer = By.xpath("//div[@id='clients_filter']//input[@type='search']");
    private By labelTotalCustomers = By.xpath("//span[normalize-space()='Total Customers']/preceding-sibling::span");
    private By firstRowItemCustomer = By.xpath("//table[@id='clients']//tbody/tr[1]/td[3]/a");

    //Locators for New Customer Page
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVatNumber = By.xpath("//input[@id='vat']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZip = By.xpath("//input[@id='zip']");
    private By dropdownGroups = By.xpath("//button[contains(@data-id,'groups_in')]");
    private By inputSearchGroups = By.xpath("//button[contains(@data-id,'groups_in')]/following-sibling::div//input[@type='search']");
    private By dropdownCurrency = By.xpath("//button[contains(@data-id,'default_currency')]");
    private By inputSearchCurrency = By.xpath("//button[contains(@data-id,'default_currency')]/following-sibling::div//input[@type='search']");
    private By dropdownLanguage = By.xpath("//button[contains(@data-id,'default_language')]");
    private By optionLanguageVietnamese = By.xpath("//span[normalize-space()='Vietnamese']");
    private String optionLanguageDynamic = "(//span[normalize-space()='%s'])[%d]";
    private By dropdownCountry = By.xpath("//button[contains(@data-id,'country')]");
    private By inputSearchCountry = By.xpath("//button[contains(@data-id,'country')]/following-sibling::div//input[@type='search']");
    private By buttonSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");

    private By alertMessage = By.xpath("//div[@id='alert_float_1']//span[@class='alert-title']");

    public void selectLangauge(String language) {
        WebUI.clickElement( dropdownLanguage);
        String xpathLanguage = "//span[normalize-space()='" + language + "']";
        System.out.println("Selecting language: " + language);
        WebUI.clickElement( By.xpath(xpathLanguage));
    }

    public void verifyCustomerPageDisplayed() {
        WebUI.highlightElement((By) DriverManager.getDriver().findElement(headerCustomerPage));
        boolean isDisplayed = false;
        try {
            isDisplayed = DriverManager.getDriver().findElement(headerCustomerPage).isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        System.out.println("Is Customer Page displayed? " + isDisplayed);

        Assert.assertTrue(isDisplayed, "Customer Page is not displayed!");
    }

    public void clickAddNewCustomerButton() {
        WebUI.clickElement( buttonAddNewCustomer);
    }

    public void fillDataNewCustomer(String company, String group, String currency, String language, String country) {
        WebUI.setText( inputCompany, company);
        WebUI.setText( inputVatNumber, "10");
        WebUI.setText( inputPhone, "09392006009");
        WebUI.setText( inputWebsite, "https://anhtester.com");
        WebUI.setText( inputAddress, "123 Street, City Center");
        WebUI.setText( inputCity, "Can Tho");
        WebUI.setText( inputState, "Can Tho");
        WebUI.setText( inputZip, "12345");

        // Select Group
        WebUI.clickElement( dropdownGroups);
        WebUI.setText( inputSearchGroups, group);
        WebUI.clickElement( By.xpath("//span[normalize-space()='" + group + "']"));
        WebUI.clickElement( dropdownGroups); // Close the dropdown

        // Select Currency
        WebUI.clickElement( dropdownCurrency);
        WebUI.setText( inputSearchCurrency, currency);
        WebUI.clickElement( By.xpath("//span[contains(text(),'" + currency + "')]"));

        // Select Language
        selectLangauge(language);

        // Select Country
        WebUI.clickElement( dropdownCountry);
        WebUI.setText( inputSearchCountry, country);
        WebUI.clickElement( By.xpath("//span[normalize-space()='" + country + "']"));
    }

    public void clickSaveButton() {
        WebUI.clickElement( buttonSave);
    }

    public void verifyAlertMessageSuccessDisplayed() {
        boolean isDisplayed = false;
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(5), Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(alertMessage));
            isDisplayed = DriverManager.getDriver().findElement(alertMessage).isDisplayed();
            WebUI.highlightElement((By) DriverManager.getDriver().findElement(alertMessage));
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        System.out.println("Is Alert message displayed? " + isDisplayed);
        Assert.assertTrue(isDisplayed, "Alert message is not displayed!");

        String alertText = DriverManager.getDriver().findElement(alertMessage).getText();
        System.out.println("Alert message: " + alertText);
        Assert.assertEquals(alertText, "Customer added successfully.", "Alert message does not match expected!");
    }

    public void verifyCustomerDetail(String company, String group, String currency, String language, String country){

        String companyValue = DriverManager.getDriver().findElement(inputCompany).getAttribute("value");
        System.out.println("company value name: " + companyValue);
        Assert.assertEquals(companyValue, company, "Company value does not match expected!");

        String vatValue = DriverManager.getDriver().findElement(inputVatNumber).getAttribute("value");
        System.out.println("company value name: " + vatValue);
        Assert.assertEquals(vatValue, "10", "VAT value does not match expected!");


    }
}
