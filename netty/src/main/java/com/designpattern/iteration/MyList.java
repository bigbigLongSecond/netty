package com.designpattern.iteration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dzl
 * 2020/10/27 14:22
 * @Description
 */
public class MyList<S> implements Iterable<S> {
    List<S> list = new ArrayList<>();
    public void add(S string){
        list.add(string);
    }

    @Override
    public Iteration<S> iterator() {
        return new Itr();
    }

    class Itr implements Iteration<S> {
        int cursor = 0;

        @Override
        public S next() {
            return  list.get(cursor++);
        }

        @Override
        public boolean hasNext() {
            return list.size() >cursor;
        }
    }

}
