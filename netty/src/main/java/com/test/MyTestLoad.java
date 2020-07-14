package com.test;

/**
 * @author dzl
 * 2020/3/31 9:55
 * @Title: MyTestLoad
 * @Description
 */
public class MyTestLoad {
    public static int a = 10;
    {
        System.out.println(" normal init");
    }
    static {
        System.out.println("static init" + a);
        a= 20;
        System.out.println();
    }

    static int s_b=2;

    public MyTestLoad() {
        System.out.println("MyTestLoad  invoke");
        System.out.println("a's value ==>"+a);
    }

    public static void sysLog(){

    }
}
