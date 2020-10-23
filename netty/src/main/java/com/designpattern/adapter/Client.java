package com.designpattern.adapter;

/**
 * @author dzl
 * 2020/10/20 16:23
 * @Description 适配器模式
 */
public class Client {
    public static void main(String[] args) {
        HomeBattery homeBattery = new HomeBattery();
        UseLine useLine = new UseLine();
        useLine.charge(homeBattery.supply());
    }
}
