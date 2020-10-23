package com.designpattern.decoration.increase;

/**
 * @author dzl
 * 2020/10/22 14:18
 * @Description
 */
public class StickyHookHouseDecoration implements IStickyHookHouse {
    private final IHouse house;

    public StickyHookHouseDecoration(IHouse house) {
        this.house = house;
    }

    @Override
    public void hangThing() {
        System.out.println("可以挂东西");
    }

    @Override
    public void live() {
        house.live();
    }
}
