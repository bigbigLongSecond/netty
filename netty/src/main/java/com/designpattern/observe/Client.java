package com.designpattern.observe;

/**
 * @author dzl
 * 2020/10/26 14:51
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        Observe observe1 = new PoliceObserver();
        Observe observe2 = new PoliceObserver();
        Observe observe3 = new PoliceObserver();
        CrimObservable observable = new CrimObservable();
        observable.addObserve(observe1);
        observable.addObserve(observe2);
        observable.addObserve(observe3);
        observable.crime("fake news");
    }
}
