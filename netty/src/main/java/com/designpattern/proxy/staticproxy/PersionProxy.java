package com.designpattern.proxy.staticproxy;

/**
 * @author dzl
 * 2020/10/26 9:48
 * @Description
 */
public class PersionProxy implements IPerson {
    private IPerson iPerson;

    public PersionProxy(IPerson iPerson) {
        this.iPerson = iPerson;
    }

    @Override
    public void eat() {
        iPerson.eat();
    }

    @Override
    public void sleep() {
        iPerson.sleep();
    }
}
