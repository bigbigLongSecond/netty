package com.designpattern.intermediary.current;

/**
 * @author dzl
 * 2020/7/10 15:21
 * @Description
 */
public abstract class AbstractColleague {
    protected int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number){
        this.number = number;
    }
    //注意这里的参数不再是同事类，而是一个中介者
    public abstract void setNumber(int number, AbstractMediator am);
}
