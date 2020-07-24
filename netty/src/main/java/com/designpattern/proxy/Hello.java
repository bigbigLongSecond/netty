package com.designpattern.proxy;

/**
 * @author dzl
 * 2020/7/15 11:16
 * @Description
 */
public class Hello implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("Hello world");
    }
}
