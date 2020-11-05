package com.designpattern.observe;

/**
 * @author dzl
 * 2020/10/26 14:48
 * @Description
 */
public class PoliceObserver implements Observe {
    @Override
    public void update(String string) {
        System.out.println("警察收到消息： " + string );
    }
}
