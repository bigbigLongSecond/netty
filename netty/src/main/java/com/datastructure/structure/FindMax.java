package com.datastructure.structure;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author dzl
 * 2020/4/24 12:26
 * @Description
 */
public class FindMax {

    public static void main(String[] args) {
        FindMax findMax = new FindMax();
//        int[] a = {12,43,45,35,3,53,53,53,53,5,352235,4,65,45,5745,6467,768,56,845,85,75,86,7,7665,545};
//        findMax.findMax(a);
//        long currt = System.currentTimeMillis();
//        boolean prime = isPrime(999999937);
//        System.out.println((System.currentTimeMillis() - currt)+"  " + prime);
        float num = 0.9f;
        BigDecimal bigDecimal = new BigDecimal(num).setScale(2, RoundingMode.HALF_EVEN);
        System.out.println(bigDecimal.floatValue());
    }

    public void findMax(int[] a){
        int max = 0;
        int min = 0;
        int alength = a.length;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > max){
                alength = max;
                max = a[i];
                min = alength;
            }else if (a[i] >min && a[i]<max){
                min = a[i];
            }
        }
        System.out.println("min  :" +min +", max  :" +max);
    }

    public void findCommonDivisor(int num1 , int num2){
//        int divisor = 1;
//        int index = 0;
//        while (index++ <= Math.min(num1,num2)){
//            if (num1%index == 0 && num2%index == 0){
//                num1 = num1/index;
//                num2 = num2/index;
//                divisor *= index;
//                index = 1;
//            }
//        }
        while(num1 != 0){
            int temp = num1;
            num1 = num2 % num1;
            num2 = temp;
        }
//        while (num1 != num2){
//            if (num1 < num2){
//                num2 = num2 - num1;
//            }else {
//                num1 = num1 - num2;
//            }
//        }
        System.out.println(num2);
    }
    public void findCommonMultiple(int num1 , int num2){
        int count = num1 * num2;
        while(num1 != 0){
            int temp = num1;
            num1 = num2 % num1;
            num2 = temp;
        }
        System.out.println(count /num2);
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num%i == 0) {
                return false;
            }
            
        }
        return true;
    }
}
