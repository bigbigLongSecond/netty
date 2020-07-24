package com.test;

import com.spring.first.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dzl
 * 2020/7/9 10:08
 * @Description   1.创建类模式   2.结构类   3.行为类
 *
 */
public class Clone {
    public static void main(String[] args) {
//        CloneTest test = new CloneTest("hell");
//        CloneTest clone = test.clone();
//        System.out.println(clone.name);
        ObservableList<Student> list = FXCollections.observableArrayList();
        ObservableList<Student> list1 = FXCollections.observableArrayList();
        list.add(new Student("xiao",1));
        list1.add(new Student("xiao2",2));
        list1.add(new Student("xiao3",3));
        list1.add(new Student("xiao4",4));
        list1.add(new Student("xiao5",5));
        list.addAll(list1);
        list1.clear();
        System.out.println(list);
    }
}
