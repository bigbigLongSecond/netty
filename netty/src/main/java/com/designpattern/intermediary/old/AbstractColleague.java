package com.designpattern.intermediary.old;

/**
 * @author dzl
 * 2020/7/10 15:16
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
    //抽象方法，修改数字时同时修改关联对象
    public abstract void setNumber(int number, AbstractColleague coll);
}
