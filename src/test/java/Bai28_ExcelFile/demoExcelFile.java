package Bai28_ExcelFile;

import org.Helpers.ExcelHelper;
import org.testng.annotations.Test;

public class demoExcelFile{
    @Test
    public void testReadExcelFile(){
        System.out.println("Read excel file: ");
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/DataCRM/DataCRM.xlsx", "Login");

        System.out.println(excel.getCellData("EMAIL", 1));
        System.out.println(excel.getCellData("PASSWORD", 1));
    }

    @Test
    public void testWriteExcelFile(){
        System.out.println("Write excel file: ");

    }
}
