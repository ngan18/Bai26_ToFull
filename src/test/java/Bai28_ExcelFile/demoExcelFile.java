package Bai28_ExcelFile;

import Bai27_PropertiesFile.pages.LoginPage;
import common.BaseTest;
import org.Helpers.ExcelHelper;
import org.testng.annotations.Test;

public class demoExcelFile extends BaseTest {
    @Test
    public void testReadExcelFile(){
        System.out.println("Read excel file: ");
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/DataCRM/DataCRM.xlsx", "Login");

        System.out.println(excel.getCellData("EMAIL", 1));
        System.out.println(excel.getCellData("PASSWORD", 1));

        LoginPage loginPage = new LoginPage();

        loginPage.loginCRM(
                excel.getCellData("EMAIL", 1),
                excel.getCellData("PASSWORD", 1));
    }

    @Test
    public void testWriteExcelFile(){
        System.out.println("Write excel file: ");
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/DataCRM/DataCRM.xlsx", "Login");

        //Ghi giá trị "pass" vào dòng 1 cột 3 (dòng và cột bắt đầu tính từ 0)
        excel.setCellData("pass", "Test_Result", 1);

    }
}
