package com.designpattern.review.bridging;

/**
 * @author dzl
 * 2020/10/22 9:57
 * @Description  桥接模式
 *   面临的业务场景是：1.绘制矩形、圆形、三角形这三种图形
 *   每种矩形要能具有四种颜色
 *   桥接模式用于多个同级别的接口
 *   假如我用工厂模式来实现这个需求呢   ---> 工厂模式强调的是调用者知道最少的类信息，来傻瓜式的获取一个类。而获取一个带颜色的图形
 *   我们要用很多工厂来解决。装配者模式也可以用这个需求。桥接模式的本质是吧两个同一级别的接口统一起来。如果一个接口用了implements,那么另一个就是
 *   全局变量
 *
 */
public class Client {
    public static void main(String[] args) {
        Blue blue = new Blue();
        Rectangle iShape = new Rectangle();
        iShape.setiColor(blue);
        iShape.draw();
    }
}
