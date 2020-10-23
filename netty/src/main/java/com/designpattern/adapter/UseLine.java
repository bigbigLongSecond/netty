package com.designpattern.adapter;

/**
 * @author dzl
 * 2020/10/20 16:19
 * @Description
 */
public class UseLine {
    void charge(int volt){
        if (volt != 5)
            throw new IllegalArgumentException("只能接受5v电压");
        System.out.println("正常充电");
    }
}
