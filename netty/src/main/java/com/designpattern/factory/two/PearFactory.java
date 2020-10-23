package com.designpattern.factory.two;

import com.designpattern.factory.one.Apple;
import com.designpattern.factory.one.Fruit;
import com.designpattern.factory.one.Pear;

/**
 * @author dzl
 * 2020/10/20 15:14
 * @Description
 */
public class PearFactory {
    public Fruit create(){
        return new Pear();
    }
}
