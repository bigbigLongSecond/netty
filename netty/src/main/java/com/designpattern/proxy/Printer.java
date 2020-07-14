package com.designpattern.proxy;

/**
 * @author dzl
 * 2020/5/27 17:17
 * @Description
 */
public class Printer implements PrintAble {

    String name ;
    @Override
    public void setPrintName(String name) {
        this.name = name;

    }
    private void heavyWork(){
        System.out.println("本人：" + name);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getPrintName() {
        return name;
    }

    @Override
    public void print(String word) {
        System.out.println("打印机" + name+"工作");
        System.out.println(word);
        System.out.println("完成工作");
    }
}
