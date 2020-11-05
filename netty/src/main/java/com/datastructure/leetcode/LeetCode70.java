package com.datastructure.leetcode;

/**
 * @author dzl
 * 2020/10/26 17:00
 * @Description
 */
public class LeetCode70  {
    public static void main(String[] args) {
        LeetCode70 leetCode70 =new LeetCode70();
        System.out.println(leetCode70.climbStairs(5));;

    }



    public int climbStairs(int n) {
        int i =1 , j = 2, count = 0;
        if (n <= 2){
            return n;
        }
        while (n--  > 2){
            count = i + j;
            i = j;
            j = count;
        }
        return count;
    }
}
