package com.designpattern.factory.two;

import com.designpattern.factory.one.Fruit;

/**
 * @author dzl
 * 2020/10/20 15:16
 * @Description  工厂方法模式
 */
public class Client {
    public static void main(String[] args) {
        Fruit apple = new AppleFactory().create();
    }
}
