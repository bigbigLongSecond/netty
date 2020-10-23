package com.designpattern.factory.one;

/**
 * @author dzl
 * 2020/10/20 15:04
 * @Description
 */
public class FruitFactory {
    public Fruit create(String type) {
        switch (type) {
            case "apple":
                return new Apple();
            case "pear":
                return new Pear();
            default:
                return null;
        }
    }
}
