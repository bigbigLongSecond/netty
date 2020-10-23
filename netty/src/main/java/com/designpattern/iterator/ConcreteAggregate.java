package com.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dzl
 * 2020/8/17 10:58
 * @Description
 */
public class ConcreteAggregate implements Aggregate {

    private List list = new ArrayList();

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(list);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

}
