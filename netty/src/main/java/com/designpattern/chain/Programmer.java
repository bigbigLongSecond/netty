package com.designpattern.chain;

/**
 * @author dzl
 * 2020/10/27 13:38
 * @Description
 */
public abstract class Programmer  {
    private Programmer programmer;

    public Programmer getProgrammer() {
        return programmer;
    }

    public void setProgrammer(Programmer programmer) {
        this.programmer = programmer;
    }

    public Programmer() {
    }

    public abstract void solve(Bug questionValue);
}
