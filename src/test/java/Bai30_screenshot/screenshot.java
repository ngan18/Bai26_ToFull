package Bai30_screenshot;

import common.BaseTest;
import org.Helpers.CaptureHelper;
import org.Helpers.SystemHelper;
import org.keywords.DriverManager;
import org.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class screenshot extends BaseTest {

    @Test
    public void testTakeScreenshot(Method method) {
        WebUI.openURL("https://anhtester.com");
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Anh Tester Automation Testing");
      //  CaptureHelper.takeScreenshot("IMG_HomePage");
        WebUI.clickElement(By.xpath("//a[@id='btn-login']"));
        WebUI.waitForPageLoaded();
       // CaptureHelper.takeScreenshot(method.getName() + "_" + SystemHelper.getDateTimeNowFormat());
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()){
            CaptureHelper.takeScreenshot(result.getName() + "_" + SystemHelper.getDateTimeNowFormat());

        }

    }


}
