package com.designpattern.proxy.staticproxy;

/**
 * @author dzl
 * 2020/10/26 9:48
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        IPerson iPerson = new Person();
        iPerson.eat();
        iPerson.sleep();
        IPerson person = new PersionProxy(iPerson);
        person.eat();
        person.sleep();

    }
}
