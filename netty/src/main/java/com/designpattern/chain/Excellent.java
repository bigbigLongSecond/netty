package com.designpattern.chain;

/**
 * @author dzl
 * 2020/10/27 13:49
 * @Description
 */
public class Excellent extends Programmer {
    @Override
    public void solve(Bug questionValue) {
        if (questionValue.value > 20) {
            System.out.println("优秀程序员解决问题");
        }
    }
}
