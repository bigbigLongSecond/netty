package com.test;

import java.sql.SQLException;
import java.util.*;

/**
 * @author dzl
 * 2020/3/31 9:09
 * @Title: JdbcConntection
 * @Description
 */
public class JdbcConntection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        System.out.println(System.getProperty("jdbc.drivers"));
//        System.out.println(JdbcConntection.class.toString());
//        System.out.println(Thread.currentThread().getContextClassLoader());
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("localhost:3306" , "" , "");
//        System.out.println(System.getProperty("jdbc.drivers"));
//        List<String>  a = Arrays.asList("Hello" ,"world" ,"yes");
//        String d = "he";
//        String e = "hle";
//        String f = "he";
////        List<String> b  = new LinkedList<String>(a);
////        b.add(d);
////        b.add(e);
////        b.contains(d);
//        List<String>  c = new ArrayList<String>();
//        c.add(d);
//        c.add(e);
//        c.add(f);
//        c.contains("he");
        List<Node>  list = new ArrayList<Node>();
        Node node = new Node();
        list.add(node);
        list.add(node);
        System.out.println(list.size());

        System.out.println(list.get(0) == list.get(1));
        list.get(0).setA("hello");
        System.out.println(list.get(1).getA());
    }

}

class Node{
    String a ;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}