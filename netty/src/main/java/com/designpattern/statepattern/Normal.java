package com.designpattern.statepattern;

/**
 * @author dzl
 * 2020/10/26 15:40
 * @Description
 */
public class Normal implements IUser {
    @Override
    public void mockInterview() {
        System.out.println("面试测试是会员的专属服务");
    }
}
