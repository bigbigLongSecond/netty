package com.designpattern.templete;

/**
 * @author dzl
 * 2020/7/10 15:11
 * @Description
 */
public class Client {
    public static int[] a = { 10, 32, 1, 9, 5, 7, 12, 0, 4, 3 }; // 预设数据数组
    public static void main(String[] args){
        AbstractSort s = new ConcreteSort();
        s.showSortResult(a);
    }
}
