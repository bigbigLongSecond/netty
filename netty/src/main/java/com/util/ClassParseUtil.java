package com.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassParseUtil {

    public static List<Class<?>> getClass(String packagename) {
        List<Class<?>> classes = new ArrayList<Class<?>>();

        String packDir = packagename.replace('.', '/');
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packDir);
            while (dirs.hasMoreElements()) {
                URL url = (URL) dirs.nextElement();
                findAndAddClassesInPackageByFile(url.getPath(), packagename, true, classes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }

    private static void findAndAddClassesInPackageByFile(String packagename, String filePath, final boolean flag,
                                                         List<Class<?>> classes) {
        File dir = new File(packagename);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        File[] dirFiles = dir.listFiles(pathname -> (flag && pathname.isDirectory()) || (pathname.getName().endsWith(".class")));

        assert dirFiles != null;
        for (File file : dirFiles) {
            if (file.isDirectory()) {

                findAndAddClassesInPackageByFile(file.getPath(), filePath, flag, classes);
            } else {
                String packPath = null;
                String path = file.getPath().replace("\\", ".");
                if (path.contains(filePath)) {
                    packPath = path.substring(path.indexOf(filePath));
                }
                String className = packPath.substring(0, packPath.length() - 6);
                try {
                    classes.add(Class.forName(className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static String getPropertiesFolder() {
        String path = "";
        String jarFilePath = getJarPath();
        try {
            jarFilePath = URLDecoder.decode(jarFilePath, "UTF-8");
            if (null != jarFilePath) {
                String[] filepaths = jarFilePath.split("/");
                path = jarFilePath.replace("/" + filepaths[filepaths.length - 1], "");
                if (!path.endsWith("/")) {
                    path += "/";
                }
                // path = path.substring(1, path.length());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return path;
    }


    public static String getJarPath() {
        return ClassParseUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    }

}
