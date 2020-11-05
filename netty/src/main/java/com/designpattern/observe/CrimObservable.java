package com.designpattern.observe;

/**
 * @author dzl
 * 2020/10/26 14:49
 * @Description
 */
public class CrimObservable extends Observable {
    public void crime(String event){
        System.out.println("罪犯正在： " + event);
        notifyObserves(event);
    }
}
