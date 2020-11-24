package com.spring.second;

/**
 * @author dzl
 * 2020/11/18 9:13
 * @Description
 */
public class HelloWorldImpl2 implements HelloWorld {

    @Override
    public void printHelloWorld() {
        System.out.println("------222222------按下HelloWorld2.printHelloWorld()------2222222------");
    }

    @Override
    public void doPrint() {
        System.out.println("-------22222-----打印HelloWorldImpl2------22222-----");
        return ;
    }
}
