package com.designpattern.intermediary.current;

/**
 * @author dzl
 * 2020/7/10 15:23
 * @Description
 */
public class ColleagueB extends AbstractColleague{

    @Override
    public void setNumber(int number, AbstractMediator am) {
        this.number = number;
        am.BaffectA();
    }
}