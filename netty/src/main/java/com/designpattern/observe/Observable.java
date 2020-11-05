package com.designpattern.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dzl
 * 2020/10/26 14:38
 * @Description  被观察者父类
 */
public class Observable {
    private List<Observe> observes = new ArrayList<>();
    public void addObserve(Observe observe){
        observes.add(observe);
    }
    public void removeObserve(Observe observe){
        observes.remove(observe);
    }
    public void notifyObserves(String event){
        for (Observe observe :observes)
            observe.update(event);

    }
}
