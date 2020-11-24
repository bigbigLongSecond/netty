package com.datastructure.leetcode;

import java.util.ArrayList;

/**
 * @author dzl
 * 2020/11/6 14:39
 * @Description 给你一个大小为 k 的整数数组 balls ，其中 balls[i] 是颜色为 i 的球的数量
 * 难点，创建两堆  判断这两堆的颜色是否相等
 */
public class LeetCode1467 {
    public static void main(String[] args) {
        int[] a = {2, 1, 1};
        LeetCode1467 code1467 = new LeetCode1467();
        code1467.getProbability(a);
    }

    public double getProbability(int[] balls) {
        int[] allBalls = getAllBalls(balls);
        int[] marks = new int[allBalls.length];
        return 0;
    }




    private int[] getAllBalls(int[] balls) {
        int temp = 0;
        for (int i = 0; i < balls.length; i++) {
            temp += balls[i];
        }
        int[] arrays = new int[temp];
        temp = 0;
        for (int i = 0; i < balls.length; i++) {
            for (int j = 0; j < balls[i]; j++) {
                arrays[temp++] = i;
            }
        }
        return arrays;
    }


}
