package com.designpattern.iteration;

/**
 * @author dzl
 * 2020/10/27 14:22
 * @Description  迭代器模式  我们有一个类中存在一个列表。这个列表需要提供给外部类访问，但我们不希望外部类修改其中的数据。
 */
public class Client {
    public static void main(String[] args) {
        MyList<String> myList = new MyList();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        Iteration<String> iteration = myList.iterator();
        while (iteration.hasNext()){
            String next = iteration.next();
            next = "123";
        }
        System.out.println("je");
    }
}
