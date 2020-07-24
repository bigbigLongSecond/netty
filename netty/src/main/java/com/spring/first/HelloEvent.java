package com.spring.first;

import org.springframework.context.ApplicationEvent;

/**
 * @author dzl
 * 2020/7/22 10:36
 * @Description
 */
public class HelloEvent extends ApplicationEvent {
    private String name ;
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public HelloEvent(Object source , String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
