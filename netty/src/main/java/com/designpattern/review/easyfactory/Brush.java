package com.designpattern.review.easyfactory;

/**
 * @author dzl
 * 2020/10/21 9:45
 * @Description
 */
public class Brush implements Stationary {
    @Override
    public void write() {
        System.out.println("Brush 毛笔  write");
    }
}
