package com.designpattern.combination;

/**
 * @author dzl
 * 2020/10/22 11:10
 * @Description
 */
public class TextField extends File {

    public TextField(String fileName) {
        super(fileName);
    }

    @Override
    public void display() {
        System.out.println( getFileName());
    }
}
