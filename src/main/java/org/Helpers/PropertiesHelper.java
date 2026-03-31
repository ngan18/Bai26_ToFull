package org.Helpers;

import org.Utils.LogUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

public class PropertiesHelper {

    private static Properties properties;
    private static String linkFile;
    private static FileInputStream fileIn;
    private static FileOutputStream fileOut;
    private static String relPropertiesFilePathDefault = "src/test/resources/configs/config.properties";

    public static Properties loadAllFiles() {
        LinkedList<String> files = new LinkedList<>();
        // Add tất cả file Properties vào đây theo mẫu
        files.add("src/test/resources/configs/config.properties");
//        files.add("src/test/resources/configs/local.properties");
//        files.add("src/test/resources/configs/production.properties");

        try {
            properties = new Properties();

            for (String f : files) {
                Properties tempProp = new Properties();
                linkFile = SystemHelper.getCurrentDir() + f;
                fileIn = new FileInputStream(linkFile);
                tempProp.load(fileIn);
                properties.putAll(tempProp);
            }
            return properties;
        } catch (IOException ioe) {
            return new Properties();
        }
    }

    public static void setFile(String relPropertiesFilePath) {
        properties = new Properties();
        try {
            linkFile = SystemHelper.getCurrentDir() + relPropertiesFilePath;
            fileIn = new FileInputStream(linkFile);
            properties.load(fileIn);
            fileIn.close();
        } catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    public static void setDefaultFile() {
        properties = new Properties();
        try {
            linkFile = SystemHelper.getCurrentDir() + relPropertiesFilePathDefault;
            fileIn = new FileInputStream(linkFile);
            properties.load(fileIn);
            fileIn.close();
        } catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        String value = null;
        try {
            if (fileIn == null) {
                properties = new Properties();
                linkFile = SystemHelper.getCurrentDir() + relPropertiesFilePathDefault;
                fileIn = new FileInputStream(linkFile);
                properties.load(fileIn);
                fileIn.close();
            }
            // Lấy giá trị từ file đã Set
            value = properties.getProperty(key);
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
        }
        return value;
    }

    public static void setValue(String key, String keyValue) {
        try {
            if (fileIn == null) {
                properties = new Properties();
                fileIn = new FileInputStream(SystemHelper.getCurrentDir() + relPropertiesFilePathDefault);
                properties.load(fileIn);
                fileIn.close();
                fileOut = new FileOutputStream(SystemHelper.getCurrentDir() + relPropertiesFilePathDefault);
            }
            //Ghi vào cùng file Prop với file lấy ra
            fileOut = new FileOutputStream(linkFile);
            LogUtils.info(linkFile);
            properties.setProperty(key, keyValue);
            properties.store(fileOut, null);
            fileOut.close();
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
        }
    }

}