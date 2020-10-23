package com.designpattern.review.easyfactory;

/**
 * @author dzl
 * 2020/10/21 9:44
 * @Description
 */
public class Pencil implements Stationary {

    @Override
    public void write() {
        System.out.println("铅笔write");
    }
}
