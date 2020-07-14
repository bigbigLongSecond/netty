package com.designpattern.observe;

import java.util.Vector;

/**
 * @author dzl
 * 2020/7/3 13:59
 * @Description
 */
public abstract class Subject {
    private Vector<Observer> obs = new Vector<>();

    public void addObserver(Observer observer){
        this.obs.add(observer);
    }
    public void delObserver(Observer observer){
        this.obs.remove(observer);
    }
    public void notifyObserver(){
        obs.forEach(info->info.update());
    }
    public abstract void doSomething();
}
