package com.designpattern.observe;

/**
 * @author dzl
 * 2020/7/3 14:08
 * @Description
 */
public class ConcreteObserver1 implements Observer {
    @Override
    public void update() {
        System.out.println("观察者1收到信息，并进行处理");
    }


}
