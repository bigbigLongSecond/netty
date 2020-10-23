package com.designpattern.prototype;

import com.designpattern.factory.one.Apple;

/**
 * @author dzl
 * 2020/10/21 9:06
 * @Description
 */
public class ProtoType   implements  Cloneable{
    private String type;
    private int size;
    private Apple fruit;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Apple getFruit() {
        return fruit;
    }

    public void setFruit(Apple fruit) {
        this.fruit = fruit;
    }

    @Override
    protected ProtoType clone() throws CloneNotSupportedException {
        return (ProtoType) super.clone();
    }
}
