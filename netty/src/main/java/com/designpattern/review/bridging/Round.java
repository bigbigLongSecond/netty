package com.designpattern.review.bridging;

/**
 * @author dzl
 * 2020/10/22 9:58
 * @Description
 */
public class Round implements IShape {

    private IColor iColor;

    public void setiColor(IColor iColor) {
        this.iColor = iColor;
    }

    @Override
    public void draw() {
        System.out.println("绘制一个"+ iColor.getColor() +"圆形");
    }
}
