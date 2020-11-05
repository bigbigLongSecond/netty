package com.designpattern.intermediary.current;

/**
 * @author dzl
 * 2020/7/10 15:22
 * @Description  创建型：原型 单例 简单工厂 抽象工厂 装配者
 * 结构型：组合 桥接 适配器  装饰 代理  外观 享元
 * 行为型：迭代器 观察者 策略模式 模板方法 责任链 备忘录  命令 解释器 状态 访问者 中介者
 *
 */
public class Mediator extends AbstractMediator {

    public Mediator(AbstractColleague a, AbstractColleague b) {
        super(a, b);
    }

    //处理A对B的影响
    @Override
    public void AaffectB() {
        int number = A.getNumber();
        B.setNumber(number*100);
    }

    //处理B对A的影响
    @Override
    public void BaffectA() {
        int number = B.getNumber();
        A.setNumber(number/100);
    }
}