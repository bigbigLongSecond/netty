package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dzl
 * 2020/7/1 16:47
 * @Description
 */
public class StreamTest {
    public static void main(String[] args) {
        List<StreamBean> streamBeans = new ArrayList<>();
        streamBeans.add(new StreamBean(DataType.OPEN ,"xiaozhan" , 12,1,true));
        streamBeans.add(new StreamBean(DataType.OPEN ,"ming" , 13,2,true));
        streamBeans.add(new StreamBean(DataType.OPEN ,"peng" , 13,3,true));
        streamBeans.add(new StreamBean(DataType.CLOSS ,"png" , 14,4,true));
        streamBeans.add(new StreamBean(DataType.CLOSS ,"grow" , 17,1,false));
        streamBeans.add(new StreamBean(DataType.OPEN ,"change" , 18,1,true));

        List<StreamBean> collect = streamBeans.stream().filter(StreamBean::isSs).sorted((b,x )-> x.getAge()-b.getAge()).limit(2).collect(Collectors.toList());
        for (StreamBean b:collect) {
            System.out.println(b);
        }
    }
}
