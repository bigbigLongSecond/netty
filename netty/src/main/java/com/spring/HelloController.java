package com.spring;

/**
 * @author dzl
 * 2020/7/31 17:05
 * @Description
 */
public class HelloController {
    public static void main(String[] args) {
        String[] strings = new String[10];
        for (int i = 0; i < 10; i++) {
            strings[i] = "hello"+i;
        }
        for (String key:strings) {
            System.out.println("hello World");
            System.out.println(key);
        }
    }
}
