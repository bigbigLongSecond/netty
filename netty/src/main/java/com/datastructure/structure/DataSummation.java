package com.datastructure.structure;

import java.util.Random;

/**
 * @author dzl
 * 2020/4/4 15:49
 * @Title: DataSummation
 * @Description  数组求和
 */
public class DataSummation {

    public long sumA(int[]  a , int size){
        int count = 0;
        for (int i = 0; i < size; i++) {
            count += a[i] ;
        }
        return count;
    }
    public long sumB(int[]  a , int size){
        return size<1?0:(sumB(a ,size-1) + a[size-1]);
    }

    public static void main(String[] args) {
        DataSummation dataSummation = new DataSummation();
        int[]  a = new int[100];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(100);
        }
        System.out.println(dataSummation.sumA(a , a.length));
        System.out.println(dataSummation.sumB(a , a.length));
    }


}
