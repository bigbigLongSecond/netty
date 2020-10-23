package com.designpattern.factory.two;

import com.designpattern.factory.one.Apple;
import com.designpattern.factory.one.Fruit;

/**
 * @author dzl
 * 2020/10/20 15:13
 * @Description
 */
public class AppleFactory {
    public Fruit create(){
        return new Apple();
    }
}
