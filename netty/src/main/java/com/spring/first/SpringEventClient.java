package com.spring.first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dzl
 * 2020/7/22 10:39
 * @Description
 */
public class SpringEventClient {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context.publishEvent(new HelloEvent( new Object(), "helloWold"));
    }
}
