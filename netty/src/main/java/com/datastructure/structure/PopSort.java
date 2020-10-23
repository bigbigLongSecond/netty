package com.datastructure.structure;

import java.util.Arrays;

/**
 * @Description  冒泡排序的三种进阶方法
 * 从小到大排序
 */
public class PopSort {

    public static void main(String[] args) {
//        int[] a = {1,232,32,412,32,42,34,2,32,423,1,3,42,3,12,4,4,213,25,421,4};
        PopSort popSort = new PopSort();
//        popSort.popSortC(a);
//        System.out.println(Arrays.toString(a));
        popSort.dfs(1,2);

    }

    /**
     * 第一种单纯的两层for循环
     * 每一个都跟其他的相比较，然后排序
     */

    public void popSortA(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i]>array[j]){
                    swap(array , i , j);
                }
            }
        }
    }

    /**
     * 在我们排序的过程中，如果遇到如下情况
     *  8 1 3 4 4 5 5 5 6 7
     *  当我们进行第一次排序后 整个程序已经变成了
     *  1 3 4 4 5 5 5 6 7 8
     *  不难看出整个程序已经排好序了，第一种方法并不能即使的去发现并停止这个程序，所以有了方法B
     */

    public void popSortB(int[] array){
        int hi = array.length;
       while(!bubbSort(array, hi--));
    }

    /**
     * 我们再假设：
     * 在我们排序的过程中，如果遇到如下情况
     *  8 1 3 4 4 5 5 10 10 9
     *  当我们进行第一次排序后 整个程序已经变成了
     *  1 3 4 4 5 5 8 10 9 10
     *  不难看出前面的 1 3 4 4 5 5 8 已经排好序了，只有后面的 10 9 10 三个元素
     *  存在乱序，如果我们确认最后一次发生比较的下标index,从index开始比较就可以大大节省运算量
     */
    public void popSortC(int[] array){
        int hi = array.length;
        int index = 0;
        while((index = bubbSortB(array , hi--))>0);
    }

    private int bubbSortB(int[] array, int hi) {
        int index = 0;
        int lo = 0;
        while (++lo < hi){
            if (array[lo] < array[lo-1]){
                swap(array , lo , lo-1);
                index = lo;
            }
        }
        return index;
    }


    private boolean bubbSort(int[] array, int hi) {
        boolean flag = true;
        int lo = 0;
        while (++lo < hi){
            if (array[lo] < array[lo-1]){
                swap(array , lo , lo-1);
                flag = false;
            }
        }
        return flag;
    }


    private void swap(int[] array, int i, int j) {
        int num = array[i];
        array[i] = array[j];
        array[j] = num;
    }
    /**
     * 数字全排列问题
     * n个数字能排列成几个组合
     * 1：n个数字，就意味着有n个箱子
     */

    /**
     * step one : 如何往盒子里放扑克牌
     */
//    int[] a = new int[9];
//    int[] book = new int[9];
//
    int[]  box = new int[9];
    int[] numbers = new int[9];
    public void dfs (int step , int num){
        if (step == num+1){
            for (int i = 1; i <= num; i++) {
                System.out.print(box[i]);
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= num; i++) {
            if (numbers[i] == 0){
                box[step] = i;
                numbers[i] = 1;
                dfs(step+1 , num);
                numbers[i] = 0;
            }
        }
    }

/**
 * step one: 给特定箱子放入值
 */




}
