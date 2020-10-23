package com.designpattern.review.bridging;

/**
 * @author dzl
 * 2020/10/22 9:56
 * @Description  矩形
 */
public class Rectangle implements IShape {
    private IColor iColor;

    public void setiColor(IColor iColor) {
        this.iColor = iColor;
    }

    @Override
    public void draw() {
        System.out.println("绘制一个"+ iColor.getColor() +"矩形");
    }
}
