package com.io.read;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author dzl
 * 2020/8/20 16:45
 * @Description
 */
public class FileRead {
    public static void main(String[] args) throws IOException {
        int num = 0;
        char[] buf = new char[1024];
        FileReader fileRead = new FileReader("1.txt");
        while ((num = fileRead.read(buf)) != -1) {
            System.out.println(new String(buf, 0, num));
        }
        String temp = "";
        for (int i = 0; i < buf.length; i++) {
            if ("、".equals(buf[i])) {
                System.out.println(temp);
                temp = "";
            }else {
                temp += buf[i];
            }

        }
    }
}
