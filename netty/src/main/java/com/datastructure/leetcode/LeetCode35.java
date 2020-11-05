package com.datastructure.leetcode;

/**
 * @author dzl
 * 2020/10/27 9:54
 * @Description
 */
public class LeetCode35 {
    public static void main(String[] args) {
        LeetCode35 leetCode35 = new LeetCode35();
        int[] nums =  {1,4,6,7};
        int i = leetCode35.searchInsert(nums, 2);
        System.out.println(i);
    }


    public int searchInsert(int[] nums, int target) {
        int lo = 0 , hi = nums.length-1, mid = (lo + hi )/2;
        while (lo <= hi){
            if ( nums[mid] < target){
                lo = mid+1;
            }else {
                hi = mid-1;
            }
            mid =  (lo + hi )/2;
        }
        return lo;
    }
}
