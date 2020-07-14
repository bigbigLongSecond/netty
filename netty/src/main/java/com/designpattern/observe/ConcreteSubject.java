package com.designpattern.observe;

/**
 * @author dzl
 * 2020/7/3 14:07
 * @Description
 */
public class ConcreteSubject extends Subject {


    @Override
    public void doSomething() {
        System.out.println("被观察者事件发生");
        this.notifyObserver();
    }

}
