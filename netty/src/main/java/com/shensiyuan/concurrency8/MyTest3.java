package com.shensiyuan.concurrency8;

/**
 * @author dzl
 * 2020/11/18 11:25
 * @Description
 */
public class MyTest3 {
    public static void main(String[] args) {
        MyTest3 test3 = new MyTest3();
        test3.printNum();

    }

    public int printNum() {
        try {
            System.out.println("H");
            return 2;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("hello");
        }
        System.out.println("213");
        return 0;
    }
}
