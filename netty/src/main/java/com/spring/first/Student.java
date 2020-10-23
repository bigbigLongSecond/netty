package com.spring.first;

import java.util.List;

/**
 * @author dzl
 * 2020/7/14 9:14
 * @Description
 */
public class Student {
    public String name;
    public int age;
    public List<String> list;


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
        this.name = "dzl No.1";
        System.out.println(this.name);
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
