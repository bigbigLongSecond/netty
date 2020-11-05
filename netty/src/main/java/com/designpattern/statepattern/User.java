package com.designpattern.statepattern;

/**
 * @author dzl
 * 2020/10/26 15:39
 * @Description
 */
public class User implements IUser , ISwiftStatus {
    IUser iUser = new Normal();
    @Override
    public void buy() {
        iUser = new Plus();
        System.out.println("您已升级成为会员");
    }

    @Override
    public void expire() {
        iUser = new Normal();
        System.out.println("会员到期");
    }

    @Override
    public void mockInterview() {
        iUser.mockInterview();

    }
}
