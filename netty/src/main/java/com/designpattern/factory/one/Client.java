package com.designpattern.factory.one;

/**
 * @author dzl
 * 2020/10/20 15:02
 * @Description   简单工厂模式
 */
public class Client {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new FruitFactory();
        Fruit apple = fruitFactory.create("apple");
        Fruit pear = fruitFactory.create("pear");
        apple.eat();
        pear.eat();
        
    }
}
