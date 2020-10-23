package com.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dzl
 * 2020/8/17 11:00
 * @Description
 */
public class Client {

    public static void main(String[] args){
        Aggregate ag = new ConcreteAggregate();
        ag.add("小明");
        ag.add("小红");
        ag.add("小刚");
        Iterator it = ag.iterator();
        while(it.hasNext()){
            String str = (String)it.next();
            System.out.println(str);
        }
    }
}
