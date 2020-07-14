package com.annotation;

import com.annotation.impl.UserServiceImpl;
import com.annotation.spring.SelfPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

        SelfPathXmlApplicationContext app = new SelfPathXmlApplicationContext("com.annotation");
        UserServiceImpl userServiceImpl = (UserServiceImpl) app.getBean("userServiceImpl");
        userServiceImpl.getna();
        System.out.println("当前的bean的实例对象是: " + userServiceImpl);

    }
}
