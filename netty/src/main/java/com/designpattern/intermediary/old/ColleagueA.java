package com.designpattern.intermediary.old;

/**
 * @author dzl
 * 2020/7/10 15:17
 * @Description
 */
public class ColleagueA extends AbstractColleague{
    @Override
    public void setNumber(int number, AbstractColleague coll) {
        this.number = number;
        coll.setNumber(number*100);
    }
}
