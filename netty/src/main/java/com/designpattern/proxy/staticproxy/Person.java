package com.designpattern.proxy.staticproxy;

/**
 * @author dzl
 * 2020/10/26 9:46
 * @Description
 */
public class Person implements IPerson {
    @Override
    public void eat() {
        System.out.println("Person eat");
    }

    @Override
    public void sleep() {
        System.out.println("person sleep");

    }
}
