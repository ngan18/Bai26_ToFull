package Bai29_DataProvider;

import org.Helpers.ExcelHelper;
import org.Helpers.SystemHelper;
import org.testng.annotations.DataProvider;

public class demoDataProvider{

    @DataProvider(name = "data")
    public Object[][] DataLogin() {

        return new Object[][]{{"Fisrt class", 23}, {"Second class", 68}};
    }


    @DataProvider(name = "data_login")
    public Object[][] DataLogin2() {

        return new Object[][]{
                {"admin@example.com", 123456},
                {"admin23@example.com", 612248},
                {"admopsuper@example.com", 612248}
        };
    }


    @DataProvider(name = "data_provider_login_excel", parallel = true)
    public Object[][] dataLoginFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData(SystemHelper.getCurrentDir() + "src/test/resources/DataCRM/DataCRM.xlsx", "Login");
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

    @DataProvider(name = "data_provider_login_excel_hastable", parallel = true)
    public Object[][] data_provider_login_excel_hastable() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + "src/test/resources/DataCRM/DataCRM.xlsx",
                "Login",1,2);
        System.out.println("Login Data from Excel use Hashtable: " + data);
        return data;
    }

    @DataProvider(name = "data_provider_login_excel_specific_rows", parallel = true)
    public Object[][] data_provider_login_excel_specific_rows() {
        ExcelHelper excelHelper = new ExcelHelper();
        int[] specificRows = new int[]{1, 3}; //Dòng cụ thể cần lấy
        Object[][] data = excelHelper.getDataFromSpecificRows(SystemHelper.getCurrentDir() + "src/test/resources/DataCRM/DataCRM.xlsx",
                "Login", specificRows);
        System.out.println("getDataFromSpecificRows: " + data);
        return data;
    }

    @DataProvider(name = "data_provider_login_excel_specific_rows_hashtable", parallel = true)
    public Object[][] data_provider_login_excel_specific_rows_hashtable() {
        ExcelHelper excelHelper = new ExcelHelper();
        int[] specificRows = new int[]{1,2, 3}; //Dòng cụ thể cần lấy
        Object[][] data = excelHelper.getDataHashTableFromSpecificRows(SystemHelper.getCurrentDir() + "src/test/resources/DataCRM/DataCRM.xlsx",
                "Login", specificRows);
        System.out.println("getDataHashTableFromSpecificRows: " + data);
        return data;
    }

}
