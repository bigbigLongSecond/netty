package com.review.java8;

import java.util.Optional;

/**
 * @author dzl
 * 2020/11/24 10:15
 * @Description Option
 * empty 创建一个空Option
 * of ofNullable  判断是否有值
 * orElse 判断是否有值，如果没有值则返回一个默认值。如果有值则忽略默认值
 * filter 筛选
 * map 将现有的类型改变成另外一个类型
 */
public class TestOption {
    public static void main(String[] args) {
        TestOption testOption = new TestOption();
        testOption.flatMap();
    }

    public void empty() {
        Optional<Object> empty = Optional.empty();
        empty.get();
    }

    public void of() {
        NodeSelf self = null;
        Optional.of(self);
    }

    public void ofNullable() {
        NodeSelf self = null;
        Optional<NodeSelf> self1 = Optional.ofNullable(self);
        self1.ifPresent(s -> System.out.println("123"));
        NodeSelf self2 = self1.orElse(new NodeSelf(1, 1));
        System.out.println(self2);
    }

    public void map() {
        NodeSelf self = new NodeSelf(1, 1);
        Optional.of(self).map(s -> s.type).ifPresent(System.out::println);

    }

    public void flatMap() {
        NodeSelf self = new NodeSelf(1, 1);
        Optional.of(self).flatMap(self1 -> Optional.of(self1.type)).ifPresent(System.out::print);


    }


    public void filter() {
        NodeSelf self = new NodeSelf(2, 1);
        Optional.of(self).filter(nodeSelf -> nodeSelf.type > 1).ifPresent(nodeSelf -> System.out.println(nodeSelf.type));
    }

}
