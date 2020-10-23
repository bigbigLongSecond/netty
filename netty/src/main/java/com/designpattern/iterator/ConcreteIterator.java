package com.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dzl
 * 2020/8/17 10:55
 * @Description
 */
public class ConcreteIterator implements Iterator {
    private List list = new ArrayList();
    private int cursor =0;

    public ConcreteIterator(List list){
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if(cursor==list.size()){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        Object obj = null;
        if(this.hasNext()){
            obj = this.list.get(cursor++);
        }
        return obj;
    }

}
