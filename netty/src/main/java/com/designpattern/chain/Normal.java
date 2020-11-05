package com.designpattern.chain;

/**
 * @author dzl
 * 2020/10/27 13:46
 * @Description
 */
public class Normal extends Programmer {


    @Override
    public void solve(Bug questionValue) {
        if (questionValue.value <= 20 && questionValue.value >0){
            System.out.println("初级程序员就可解决问题");
        }else {
            getProgrammer().solve(questionValue);
        }

    }
}
