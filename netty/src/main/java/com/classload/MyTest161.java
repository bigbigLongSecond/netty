package com.classload;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by [张渊]
 * 2020/3/20 19:09
 */
public class MyTest161 extends ClassLoader{

    private String classLoaderName;
    private static String path ="";
    private final String fileExtension = ".class";


    public MyTest161(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public MyTest161(ClassLoader classLoader, String classLoaderName) {
        super(classLoader);
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("MyTest16 findClass");
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteOutputStream bao = null;
        try {
            name = name.replace("." ,"\\");
            is = new FileInputStream(new File(path+name+this.fileExtension));
            bao = new ByteOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())){
                bao.write(ch);
            }
            data = bao.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                bao.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        MyTest16 load = new MyTest16("load");
        path = "C:\\workspace_14\\JvmStudy\\out\\production\\JvmStudy\\classload";
        Class clazz = load.loadClass("com.classload.MyTest1");
        Object object = clazz.newInstance();
        System.out.println(object);
//        test(load);
    }
//    public static void test(ClassLoader classLoader) throws Exception{
//        Class clazz = classLoader.loadClass("D:\\dzl\\开发计划\\DBQ\\DBQ监测-0214\\Hello");
//        Object object = clazz.newInstance();
//        System.out.println(object);
//
//    }


}
