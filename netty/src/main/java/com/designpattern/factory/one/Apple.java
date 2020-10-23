package com.designpattern.factory.one;

/**
 * @author dzl
 * 2020/10/20 15:00
 * @Description
 */
public class Apple implements Fruit {
    private int treeAge;

    public int getTreeAge() {
        return treeAge;
    }

    public void setTreeAge(int treeAge) {
        this.treeAge = treeAge;
    }

    @Override
    public void eat() {
        System.out.println("eat Apple");
    }
}
