package com.designpattern.factory;

/**
 * @author dzl
 * 2020/7/1 10:15
 * @Description
 */
public class Product implements IProduct {

    @Override
    public void createProduct() {
        System.out.println("hello");
    }

}
