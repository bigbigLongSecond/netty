package com.spring.first;

import org.springframework.context.ApplicationListener;

/**
 * @author dzl
 * 2020/7/22 10:38
 * @Description
 */
public class HelloEventListener implements ApplicationListener<HelloEvent> {
    @Override
    public void onApplicationEvent(HelloEvent event) {
        System.out.println("事件监听程序--->" + event.getName());
    }

}
