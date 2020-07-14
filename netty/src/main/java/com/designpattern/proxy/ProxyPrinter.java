package com.designpattern.proxy;

/**
 * @author dzl
 * 2020/5/27 17:22
 * @Description
 */
public class ProxyPrinter implements PrintAble {

    String name ;
    Printer printer;
    @Override
    public void setPrintName(String name) {
        if (printer != null){
            printer.setPrintName(name);
        }
        this.name = name;

    }

    @Override
    public String getPrintName() {
        return name;
    }

    @Override
    public void print(String word) {
        check();
        printer.print(word);
    }

    private synchronized void check(){
        if (printer == null){
            printer = new Printer();
        }
    }
}
