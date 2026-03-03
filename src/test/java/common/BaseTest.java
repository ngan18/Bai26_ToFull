package common;

import org.Helpers.PropertiesHelper;
import org.keywords.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {

    public SoftAssert softAssert;

    @BeforeSuite
    public void setupBeforeSuite() {

        PropertiesHelper.loadAllFiles();
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(@Optional("chrome") String browserName) {

        WebDriver driver;

        if(PropertiesHelper.getValue("browser").isEmpty() || PropertiesHelper.getValue("browser") == null){
            browserName = browserName;
        }else {
            browserName = PropertiesHelper.getValue("browser");
        }


        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                System.out.println("Launching Chrome browser...");

                ChromeOptions chromeOptions = new ChromeOptions();

                if(PropertiesHelper.getValue("headless").equalsIgnoreCase("true")){

                    chromeOptions.addArguments("--headless=new"); //set headless
                    chromeOptions.addArguments("--window_size=1920,1080");//set kích thước
                }
                driver = new ChromeDriver(chromeOptions);

                break;

            case "firefox":
                System.out.println("Launching Firefox browser...");
                driver = new FirefoxDriver();
                break;

            case "edge":
                System.out.println("Launching Edge browser...");
                driver = new EdgeDriver();
                break;

            default:
                System.out.println("Invalid browser, launching Chrome...");
                driver = new ChromeDriver();
        }

        DriverManager.setDriver(driver);  //Set to ThreadLocal
        if(PropertiesHelper.getValue("headless").equalsIgnoreCase("false")){
            DriverManager.getDriver().manage().window().maximize();

        }
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(PropertiesHelper.getValue("PAGE_LOAD_TIMEOUT"))));

        softAssert = new SoftAssert();
    }


    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (DriverManager.getDriver() != null) {
            DriverManager.quitDriver();
            softAssert.assertAll();
        }
    }

}
