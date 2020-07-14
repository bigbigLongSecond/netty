package com.designpattern.singleton;

/**
 * @author dzl
 * 2020/7/1 9:46
 * @Description  饿汉式单例模式
 */
public class SingleTonHungry {
    private static SingleTonHungry singleTon = new SingleTonHungry();

    private SingleTonHungry() {
    }
    public static SingleTonHungry getInstance(){
        return  singleTon;
    }
}
