package com.designpattern.factory.three;

import com.designpattern.factory.one.Fruit;
import com.designpattern.factory.one.Pear;

/**
 * @author dzl
 * 2020/10/20 15:19
 * @Description
 */
public class PearFactory implements IFactory {
    @Override
    public Fruit create() {
        return new Pear();
    }
}
