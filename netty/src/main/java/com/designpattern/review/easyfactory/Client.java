package com.designpattern.review.easyfactory;

/**
 * @author dzl
 * 2020/10/21 10:05
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        StationaryFactory stationaryFactory = new StationaryFactory();
        Stationary stationary = stationaryFactory.create("pencil");
        stationary.write();
    }
}
