package com.datastructure;

import com.datastructure.tree.Node;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author dzl
 * 2020/4/4 15:49
 * @Title: Main
 * @Description
 * 老师让同学辨认一块矿石。甲同学说：“这既不是铁，也不是铜。”乙同学说：“这不是铁而是锡。”
 * 丙同学说：“这不是锡而是铁。”老师最后说：“你们之中，有一人两个判断都对；另一个的两个判断都错；
 * 还有一人的判断一对一错。”看看你的判断，这块矿石到底是什么？
 */
public class Main {
    public static void main(String[] args) {
        TreeSet<Node> treeSet = new TreeSet<>();
        treeSet.add(new Node());
        treeSet.add(new Node());
        treeSet.add(new Node());
    }

}
