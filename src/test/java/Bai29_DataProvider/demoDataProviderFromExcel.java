package Bai29_DataProvider;

import Bai27_PropertiesFile.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class demoDataProviderFromExcel extends BaseTest {

    @Test(dataProvider = "data_provider_login_excel", dataProviderClass = demoDataProvider.class)
    public void testLoginCRM_01(String email, String password) {
        System.out.println("Email: " + email + " | Password: " + password);
        LoginPage loginPage = new LoginPage();
        loginPage.loginCRM(email, password);
        loginPage.verifyLoginSuccess();
    }

    @Test(dataProvider = "data_provider_login_excel_hastable", dataProviderClass = demoDataProvider.class)
    public void testLoginCRM_02(Hashtable<String, String> data) {
        System.out.println("Email: " + data.get("EMAIL") + " | Password: " + data.get("PASSWORD"));
        LoginPage loginPage = new LoginPage();
        loginPage.loginCRM(data.get("EMAIL"), data.get("PASSWORD"));
        loginPage.verifyLoginSuccess();
    }

    // Sử dụng demo DataProvider với các dòng cụ thể (1, 3, 4)
    @Test(dataProvider = "data_provider_login_excel_specific_rows", dataProviderClass = demoDataProvider.class)
    public void testLoginWithSpecificRows(String email, String password) {
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }

    // Sử dụng demo DataProvider với các dòng cụ thể dạng Hashtable
// khi có nhiều trường vd: name, mail,..., dùng hastable gọi trường mong muốn,
// thay vì tạo 10 tham số chứa nó
    @Test(dataProvider = "data_provider_login_excel_specific_rows_hashtable", dataProviderClass = demoDataProvider.class)
    public void testLoginWithSpecificRowsHashtable(Hashtable<String, String> data) {
        String email = data.get("EMAIL");
        String password = data.get("PASSWORD");

        System.out.println("Username: " + email);
        System.out.println("Password: " + password);
    }


}
