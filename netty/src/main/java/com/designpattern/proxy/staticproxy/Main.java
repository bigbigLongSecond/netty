package com.designpattern.proxy.staticproxy;

/**
 * @author dzl
 * 2020/7/24 9:56
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();
        BuyHouseProxy buyHouseProxy = new BuyHouseProxy(buyHouse);
        buyHouseProxy.buyHosue();
    }
}
