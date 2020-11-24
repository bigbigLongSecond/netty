package com.review.java8;

import java.util.Arrays;

/**
 * @author dzl
 * 2020/11/23 16:31
 * @Description
 */
public class MyTest1 {
    public static void main(String[] args) {
        String[] array = {"A", "b", "L", "c", "f", "gg", "d"};
        Arrays.sort(array, (o1, o2) -> o1.toLowerCase().compareTo(o2.toLowerCase()));
        System.out.println(String.join("," , array));
    }
}
