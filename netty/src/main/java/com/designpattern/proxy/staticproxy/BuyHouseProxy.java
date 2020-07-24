package com.designpattern.proxy.staticproxy;

/**
 * @author dzl
 * 2020/7/24 9:54
 * @Description
 */
public class BuyHouseProxy implements BuyHouse {
    private BuyHouse buyHouse;

    public BuyHouseProxy(BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHosue() {
        System.out.println("准备");
        buyHouse.buyHosue();
        System.out.println("完成");
    }
}
