package com.designpattern.iteration;

/**
 * @author dzl
 * 2020/10/27 14:23
 * @Description
 */
public interface Iteration<E> {
    E next();
    boolean hasNext();

}
