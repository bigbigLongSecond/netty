package com.spring.second;

/**
 * @author dzl
 * 2020/11/18 9:12
 * @Description
 */
public class HelloWorldImpl1 implements HelloWorld {

    @Override
    public void printHelloWorld() {
        System.out.println("------11111------HelloWorld1.printHelloWorld()-----11111111-------");
    }

    @Override
    public void doPrint() {
        System.out.println("------1111111------HelloWorldImpl1-----1111111------");
    }
}
