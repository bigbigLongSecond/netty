package com.designpattern.factory;

/**
 * @author dzl
 * 2020/7/7 9:41
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        Factory factory = new Factory();
        IProduct product = factory.createProduct();
        product.createProduct();
    }
}
