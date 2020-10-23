package com.designpattern.factory.three;

import com.designpattern.factory.one.Apple;
import com.designpattern.factory.one.Fruit;

/**
 * @author dzl
 * 2020/10/20 15:18
 * @Description
 */
public class AppleFactory implements IFactory {
    @Override
    public Fruit create() {
        return new Apple();
    }
}
