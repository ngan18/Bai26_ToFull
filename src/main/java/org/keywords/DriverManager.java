package org.keywords;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverManager = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverManager.get();

    }

    public static void setDriver(WebDriver driver) {

        DriverManager.driverManager.set(driver);
    }

    public static void quitDriver() {
        DriverManager.driverManager.get().quit();
        driverManager.remove();
    }
}

