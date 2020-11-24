package com.review.java8;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dzl
 * 2020/7/20 15:31
 * @Description 获取Stream的三种方式
 * 1.Stream.of()
 * 2.利用数组或集合创建一个Stream。 Arrays.stream(). List.stream();
 * 3.基于Supplier
 * map操作，通过一些操作，返回一个新的stream
 * filter操作：一一比对元素，如果满足条件，就留下
 * reduce:聚合操作，将所有值进行处理，得到一个返回值
 * collect:对其进行集合操作
 * 合并操作 ： concat  合并两个Stream、flatMap 转换类型
 */
public class TestStream {
    public static void main(String[] args) {
        TestStream testStream = new TestStream();
        testStream.concat();

    }

    public void funtion1() {
        Stream stream = Stream.of("a", "c", "d");
        stream.forEach(System.out::print);
    }

    public void funtion2() {
        String[] array = {"a", "c", "b", "d"};
        Stream<String> stream = Arrays.stream(array);
    }

    public void funtion3() {
//        Stream<Integer> generate = Stream.generate(() -> {
//            return new Random(10).nextInt();
//        });
//        generate.limit(20).forEach(System.out::println);
        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        // 注意：无限序列必须先变成有限序列再打印:
        natual.limit(20).forEach(System.out::println);
    }


    public void map() {
//        Integer[] integers = {1,3,4,5};
//        Stream<Integer> stream = Arrays.stream(integers);
//        Stream<Integer> integerStream = stream.map(n -> n * 2);
//        integerStream.forEach(System.out::println);
        String[] array = {"aasd", "daAda ", " da ", "DAD"};
        Arrays.stream(array)
                .map(String::trim)
                .map(String::toLowerCase)
                .limit(4)
                .forEach(System.out::println);
    }

    public void filter() {
        String[] array = {"aasd", "daAda ", " da ", "DAD"};
        Arrays.stream(array)
                .map(String::trim)
                .map(String::toLowerCase)
                .filter(n -> n.length() > 4)
                .forEach(System.out::println);
    }

    public void reduce() {
        Integer[] integers = {1, 3, 4, 5};
        Optional<Integer> reduce = Arrays.stream(integers).reduce((o1, o2) -> {
            return o1 + o2;
        });
        System.out.println(reduce.get());

        List<NodeSelf> list = new ArrayList<>();
        list.add(new NodeSelf(1, 3));
        list.add(new NodeSelf(1, 4));
        list.add(new NodeSelf(2, 5));
        list.add(new NodeSelf(2, 6));
        list.add(new NodeSelf(3, 6));
    }

    public void shiftArrayToList() {
        String[] array = {"aasd", "daAda ", " da ", "DAD", "DAD"};
        List<String> collect = Arrays.stream(array).filter(o1 -> o1.length() > 10).collect(Collectors.toList());
//        System.out.println(Arrays.stream(array).collect(Collectors.joining(",")));
//        Arrays.stream(array).collect(Collectors.toSet()).forEach(System.out::println);
    }

    public void shiftListToArray() {
        List<NodeSelf> list = new ArrayList<>();
        list.add(new NodeSelf(1, 3));
        list.add(new NodeSelf(1, 4));
        list.add(new NodeSelf(2, 5));
        list.add(new NodeSelf(2, 6));
        list.add(new NodeSelf(3, 6));
        NodeSelf[] nodeSelves = list.stream().filter(nodeSelf -> nodeSelf.type > 4).toArray(NodeSelf[]::new);
        System.out.println(nodeSelves.length);
        NodeSelf[] nodeSelves1 = {};
        System.out.println(nodeSelves1.length);
    }

    public void shiftListToMap() {
        List<NodeSelf> list = new ArrayList<>();
        list.add(new NodeSelf(1, 3));
        list.add(new NodeSelf(1, 4));
        list.add(new NodeSelf(2, 5));
        list.add(new NodeSelf(2, 6));
        list.add(new NodeSelf(3, 6));
        Map<Integer, List<NodeSelf>> collect = list.stream().collect(Collectors.groupingBy(s -> s.type, Collectors.toList()));
        System.out.println(collect.size());


    }

    public void concat() {
        String[] array = {"1", "2", "23"};
        String[] array2 = {"3", "4", "23"};
        System.out.println(Stream.concat(Arrays.stream(array), Arrays.stream(array2)).distinct().collect(Collectors.joining(",")));
    }

    public void flatMap() {
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        Stream<Integer> integerStream = listStream.flatMap(integers -> integers.stream());
    }

}

class NatualSupplier implements Supplier<Integer> {
    int n = 0;

    @Override
    public Integer get() {
        n++;
        return n;
    }
}

class NodeSelf {
    public int type;
    public int name;
    public String ss;

    public NodeSelf(int type, int name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return "NodeSelf{" +
                "type=" + type +
                ", name=" + name +
                '}';
    }
}
