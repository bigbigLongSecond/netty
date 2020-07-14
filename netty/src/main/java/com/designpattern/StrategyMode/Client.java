package com.designpattern.StrategyMode;

/**
 * @author dzl
 * 2020/7/7 9:30
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        IStrategy iStrategy = new Strategy1();
        Context context = new Context(iStrategy);
        context.execute();
    }
}
