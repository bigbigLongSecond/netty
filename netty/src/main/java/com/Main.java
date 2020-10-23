package com;

import com.util.PropertiesUtil;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author dzl
 * 2020/7/31 17:00
 * @Description
 */
public class Main {
    public static void main(String[] args) {
//        Properties properties = new Properties();
////        Reader in = new InputStreamReader(new FileInputStream(filePath), chartSet);
//        try {
//            Reader in = new InputStreamReader(new FileInputStream("config.properties"),"utf-8");
//            properties.load(in);
//            properties.setProperty("username" , "zhangsan");
//
//            OutputStream outputStream = new FileOutputStream("config.properties");
//            properties.store(outputStream,null);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        PropertiesUtil util = new PropertiesUtil();
//        util.upDate("export_media_path","C:\\\\btt\\\\media\\\\hello");
//        long l = System.currentTimeMillis();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(System.currentTimeMillis()-l);
        double y = 4801;

//        DecimalFormat df = new DecimalFormat("#.#");
//        Double v = Double.parseDouble(df.format(y/1000));

        BigDecimal bg = new BigDecimal(y / 3).setScale(1, RoundingMode.DOWN);
        double v = bg.doubleValue();
        System.out.println(v);

    }
}
