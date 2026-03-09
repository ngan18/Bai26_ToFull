package org.Helpers;

import org.keywords.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SystemHelper {
    public static String getCurrentDir() {
        //noinspection UnnecessaryLocalVariable
        //lấy đường dẫn root project --> lấy đường dẫn root project:
        // VD C:\Users\Lenovo\Project

        String current = System.getProperty("user.dir") + File.separator;
        return current;
//        File.separator có:
//        Windows → \
//        Mac/Linux → /
        //=>trả về đường dẫn current = C:\Users\Lenovo\Project\

    }

    public static String getDateTimeNowFormat() {
        // Lấy thời gian hiện tại
        LocalDateTime now = LocalDateTime.now();

        // Định dạng ngày giờ theo pattern có chứa dấu : và khoảng trắng
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        // Chuyển sang chuỗi và thay thế ký tự
        String formatted = now.format(formatter)
                .replace("-", "_")
                .replace(":", "_")
                .replace(" ", "_");

        return formatted;
    }
}
