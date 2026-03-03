package Bai26_POMWithParallel.testcases;


import Bai26_POMWithParallel.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

@SuppressWarnings("ALL")
public class LoginTest extends BaseTest {

    //khai báo đối tượng trang login
    private LoginPage loginPage;
    //cần page nào thì khai báo ra hết đối tượng page đó

    @Test(priority = 1)
    public void testLoginSuccess() {
        loginPage = new LoginPage();

        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void testLoginFailureWithEmailInvalid() {
        loginPage = new LoginPage();

        loginPage.loginCRM("admin123@example.com", "123456");

        loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
    }

    @Test(priority = 3)
    public void testLoginFailureWithPasswordInvalid() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123");

        loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
    }

    @Test(priority = 4)
    public void testLoginFailureWithEmailNull() {
        loginPage = new LoginPage();
        loginPage.loginCRM("", "123456");
        loginPage.verifyLoginFailureWithEmailNull();
    }

    @Test(priority = 5)
    public void testLoginFailureWithPasswordNull() {
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "");

        loginPage.verifyLoginFailureWithPasswordNull();
    }

}
