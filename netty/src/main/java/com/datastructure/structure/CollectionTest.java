package com.datastructure.structure;

import java.util.*;

/**
 * @author dzl
 * 2020/9/22 10:00
 * @Description
 *  ArrayList: 初始时默认给一个空的构造方法
 *    add:   1. 判断是否是空的，假如是空的，就给它默认10个容量
 *           2. 假如已经有元素了，就给它的 oldCapacity + (oldCapacity >> 1)
 *           3. 已经大于最大的容量MAX_ARRAY_SIZE，就等于最大的容量
 *  remove:  如果要remove的元素是空，就找一个空的remove掉
 *           如果不为空，找到后remove，执行结束
 *  特点： 按照下标索引很方便，O(1)
 *        按照元素索引O(n)
 *        插入操作和删除操作为O(n)
 *  LinkedList:
 *     add: 在末尾添加一个元素
 *    push：在开头添加一个元素
 *    peek、peekFirst:获取到first的值
 *    peekLast：获取末尾元素的值
 *    poll、pollFirst：获取到first的值，并将其在链表中删除
 *    pollLast：获取到last的值，并将其在链表中删除
 * HashMap: 默认构造方法 负载因子--> 0.75
 *
 *
 */
public class CollectionTest {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>(10 ,10);
        map.put("hsle" , "fdf");
        map.get("hsle");
        map.containsKey("hsle");
        map.remove("hsle");
        Set<String> strings = map.keySet();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        map.replace("hsle","dsa");

    }

}
