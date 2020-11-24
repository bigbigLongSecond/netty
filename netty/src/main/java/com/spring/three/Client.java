package com.spring.three;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dzl
 * 2020/11/18 9:57
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BraveKnight br = (BraveKnight) ac.getBean("knight");
        br.saying("brave");
    }
}
