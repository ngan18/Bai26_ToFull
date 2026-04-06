package Listioner;

import org.Helpers.CaptureHelper;
import org.Utils.LogUtils;
import org.reports.AllureManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testListioner implements ITestListener {
    @Override
    public void onStart(ITestContext result) {
        LogUtils.info("Setup môi trường onStart: " + result.getStartDate());

    }

    @Override
    public void onFinish(ITestContext result) {
        LogUtils.info("Kết thúc bộ test: " + result.getEndDate());

    }

    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("Bắt đầu chạy test case: " + result.getName());

        CaptureHelper.startRecord(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("Test case " + result.getName() + " is passed.");
        LogUtils.info("==> Status: " + result.getStatus());

        CaptureHelper.takeScreenshot(result.getName());

        CaptureHelper.stopRecord();

    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.error("Test case " + result.getName() + " is failed.");
        LogUtils.error("==> Status: " + result.getStatus());

        CaptureHelper.takeScreenshot(result.getName());

        //Allure Report
//        AllureManager.saveTextLog(result.getName() + " is failed.");
//        AllureManager.saveScreenshotPNG();

        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.info("Test case " + result.getName() + " is skipped.");
        LogUtils.info("==> Status: " + result.getStatus());

        CaptureHelper.stopRecord();

    }
}
