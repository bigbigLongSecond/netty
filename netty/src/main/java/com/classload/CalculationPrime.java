package com.classload;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author dzl
 * @version 1.0
 * @date 2020/2/16 21:45
 */
public class CalculationPrime {
    private static Set<Integer> set = new HashSet<>();
    private static final int boss = 1000000;

    static {
        for (int i = 3; i < boss; i++) {
            set.add(i);
        }
    }

    public static void main(String[] args) {
        long data = System.currentTimeMillis();
        calculation(2);
        calculation(3);
        calculation(5);
        calculation(7);
        System.out.println(getPrime() + "个数字");
        printData(data);
    }

    public static Integer getPrime() {
        Iterator<Integer> integers = set.iterator();
        Integer i = null;
        while (integers.hasNext()) {
            i = integers.next();
            if (checkPrime(i)) {
                integers.remove();
            }
        }
        set.add(2);
        return set.size();
    }

    public static boolean checkPrime(Integer i) {
        for (int j = 3; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 排除一些数字
     *
     * @param factor
     */
    public static void calculation(int factor) {
        Iterator<Integer> integers = set.iterator();
        Integer i = null;
        while (integers.hasNext()) {
            i = integers.next();
            if (i % factor == 0 && factor != i) {
                integers.remove();
            }
        }
    }


    public static void printData(long oldData) {
        long currentData = System.currentTimeMillis();
        System.out.println("共运行" + ((currentData - oldData)) + "毫秒");

    }
}
