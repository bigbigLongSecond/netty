package com.designpattern.factory;

/**
 * @author dzl
 * 2020/7/1 10:16
 * @Description
 */
public class Factory implements IFactory {
    @Override
    public IProduct createProduct() {
        return new Product();
    }
}
