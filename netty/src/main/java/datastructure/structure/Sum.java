package datastructure.structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author dzl
 * 2020/4/13 16:57
 * @Description 两数之和
 */
public class Sum {

    public static void main(String[] args) {
        int[]  a = {1,3,4,5,6,7,8,2,3,4,5};
        Sum sum = new Sum();
        sum.twoSum(a , 7);

    }

    public int[] twoSum(int[] nums, int target) {
        int[]  array = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (num == nums[j] && i != j) {
                    array[0] = i;
                    array[1] = j;
                    return array;
                }
            }
        }
        return null;
    }
}
