package com.java8;

import com.spring.first.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author dzl
 * 2020/7/20 15:31
 * @Description
 */
public class TestStream {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("2");
        list1.add("3");
        Student student = new Student();
        student.setList(list1);
        list.add(student);
        Optional.ofNullable(list).get().forEach(info->{Optional.ofNullable(info.getList()).get().forEach(bean->{
            if (bean.equals("2")){
                bean = "123";
            }
        })
        ;});

        System.out.println(list);

    }
}
