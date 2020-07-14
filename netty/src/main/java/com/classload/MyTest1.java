package com.classload;

/**
 * 静态引用一个变量时，只会对该类所在类初始化，如果这个变量所在类是一个子类时，会先创建父类
 * @author dzl
 * @version 1.0
 * @date 2020/2/16 16:26
 */
public class MyTest1 {
    public static void main(String[] args) {
//        System.out.println(MyChild1.a);
        System.out.println(MyChild1.a);
    }
}

class MyParent1 {
    public static int a = new Integer(4);
    static {
        System.out.println("MyParent static block");
    }
}

class MyChild1 extends MyParent1 {
    public static  int b = 20;
    static {
        System.out.println("MyChild1 static block");
    }
}
