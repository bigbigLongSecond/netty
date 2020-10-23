package com.designpattern.decoration.increase;

/**
 * @author dzl
 * 2020/10/22 14:17
 * @Description
 */
public class House implements IHouse {
    public void step(){
        System.out.println("bandaotiehe");
    }

    @Override
    public void live() {
        System.out.println("房子可以住人");
    }
}
