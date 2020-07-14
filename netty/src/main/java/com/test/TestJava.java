package com.test;

import java.util.HashMap;

public class TestJava {

 

    public static void main(String[] args) {

 

        HashMap map = new HashMap();

        Test t1 = new Test();

        Test t2 = new Test();

        map.put(t1, "1");

        map.put(t2, "2");

        t1 = null;

        System.gc();

        System.out.println("第1步" + map);

 

        t2 = null;

        System.gc();

        System.out.println("第2步" + map);

 

        map.clear();

        System.gc();

        System.out.println("第3步" + map);

 

    }

 

 

}


