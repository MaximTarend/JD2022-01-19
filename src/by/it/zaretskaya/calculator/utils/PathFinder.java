package by.it.zaretskaya.calculator.utils;

import java.io.File;

public class PathFinder {
    private PathFinder() {
    }

    public static final String USER_DIR = "user.dir";
    public static final String POINT_SYMBOL = ".";

    public static String getFileName(Class<?> aClass, String root, String filename) {
        return System.getProperty(USER_DIR)+
                File.separator+root+File.separator+
        aClass.getPackageName().replace(POINT_SYMBOL,File.separator)+
                File.separator+
                filename;

    }
}