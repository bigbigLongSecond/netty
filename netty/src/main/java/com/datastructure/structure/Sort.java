package com.datastructure.structure;

import java.util.Arrays;

/**
 * @author dzl
 * 2020/9/24 15:25
 * @Description
 *  冒泡排序包括两个步骤： 1.找出一个数，2.将这个数和其他所有的数做比较，并将这两个值交换   ----> 最大值/最小值
 *                      2.找下一个数， 将其和剩余的数做比较 ----> 次大值/次小值
 *  快速排序：1.找一个基准点。然后从两头出发，找到大于、小于这个数的点。然后交换他们的位置 如果两个位置相遇。本次循环结束
 */
public class Sort {
    public static void main(String[] args) {
        int[] a = new int[30];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(a));
        System.out.println("-------------------------");
        Sort sort = new Sort();
        sort.sortBigToSmallB(a , 0 ,a.length-1);
    }
    public void sortBigtoSmallA(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
               if (array[i] <array[j]){
                   int a = array[i];
                   array[i] = array[j];
                   array[j] = a;
               }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //12,35,99,18,76
    public void sortBigToSmallB(int[] array , int lo , int hi){
        int i , j ,t ,temp;
       if (lo > hi) {
           return;
       }
       temp = array[lo];
       i = lo;
       j = hi;
       while (i != j){
           while (array[j] >= temp && i < j) {
               j--;
           }
           while (array[i] <= temp && i<j) {
               i++;
           }
           if (i<j){
               t=array[i];
               array[i]=array[j];
               array[j]=t;
           }
       }
        array[lo]=array[i];
        array[i]=temp;
        System.out.println(Arrays.toString(array));
        sortBigToSmallB(array,lo ,i-1);
        sortBigToSmallB(array,i+1 ,hi);
    }

    private void swap(int[] array, int i, int j) {
        int num = array[i];
        array[i] = array[j];
        array[j] = num;
    }


}
