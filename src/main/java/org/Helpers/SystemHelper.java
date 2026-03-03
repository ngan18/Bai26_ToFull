package org.Helpers;

import java.io.File;

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
}
