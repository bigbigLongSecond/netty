package com.io.read;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author dzl
 * 2020/8/20 16:49
 * @Description
 */
public class BufferedRead {
    public static void main(String[] args) throws IOException {
        int position = 0;
        String[] bufString = new String[1024];
        BufferedReader bufferedReader = new BufferedReader(new FileReader("1.txt"));
        String line =null;
        while ((line = bufferedReader.readLine())!= null){
            bufString[position++] = line;
        }
        bufferedReader.close();
        for (String string:bufString
             ) {
            System.out.println(string);

        }
    }
}
