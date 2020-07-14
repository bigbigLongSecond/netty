package com.designpattern.observe;

/**
 * @author dzl
 * 2020/7/3 14:08
 * @Description
 */
public class ConcreteObserver2 implements Observer {
    @Override
    public void update() {
        System.out.println("观察者2收到信息，并进行处理");
    }
}
