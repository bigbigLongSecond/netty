package com.designpattern.prototype;

import com.designpattern.factory.one.Apple;

/**
 * @author dzl
 * 2020/10/21 9:08
 * @Description  原型模式
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        ProtoType protoType = new ProtoType();
        protoType.setSize(14);
        protoType.setType("原型");
        Apple fruit = new Apple();
        fruit.setTreeAge(12);
        protoType.setFruit(fruit);
        ProtoType clone = protoType.clone();
        clone.getFruit().setTreeAge(10);
        clone.setType("克隆");
        clone.setSize(13);

    }

}
