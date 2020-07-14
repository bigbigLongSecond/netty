package com.designpattern.proxy;

/**
 * @author dzl
 * 2020/5/27 17:16
 * @Description
 */
public interface PrintAble {

    void setPrintName(String name);
    String getPrintName();
    void print(String word);
}
