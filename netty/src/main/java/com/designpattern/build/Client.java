package com.designpattern.build;

/**
 * @author dzl
 * 2020/10/20 15:47
 * @Description  建造者模式
 */
public class Client {
    public static void main(String[] args) {
        MilkTea.Build build = new MilkTea.Build();
        MilkTea build1 = build.setSize("中杯").setType("奶茶").build();
    }
}
