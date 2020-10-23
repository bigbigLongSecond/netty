package com.designpattern.iterator;

/**
 * @author dzl
 * 2020/8/17 10:58
 * @Description
 */
public interface Aggregate {
    public void add(Object obj);
    public void remove(Object obj);
    public Iterator iterator();

}
