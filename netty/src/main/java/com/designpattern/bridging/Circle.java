package com.designpattern.bridging;

/**
 * @author dzl
 * 2020/10/20 16:35
 * @Description
 */
public class Circle implements IShape {
    IColor iColor;

    public Circle(IColor iColor) {
        this.iColor = iColor;
    }

    @Override
    public void draw() {

    }
}
