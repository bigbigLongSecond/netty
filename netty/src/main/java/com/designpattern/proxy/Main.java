package com.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author dzl
 * 2020/5/27 17:25
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HelloInterface hello = new Hello();
        InvocationHandler handler = new ProxyHandler(hello);
        HelloInterface proxyHello = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);
        proxyHello.sayHello();
    }
}
