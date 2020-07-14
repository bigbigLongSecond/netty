package com.designpattern.intermediary.current;

/**
 * @author dzl
 * 2020/7/10 15:21
 * @Description
 */
public abstract class AbstractMediator {
    protected AbstractColleague A;
    protected AbstractColleague B;

    public AbstractMediator(AbstractColleague a, AbstractColleague b) {
        A = a;
        B = b;
    }

    public abstract void AaffectB();

    public abstract void BaffectA();
}
