package com.datastructure.leetcode;

/**
 * @author dzl
 * 2020/10/20 10:09
 * @Description 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class LeetCode26 {

    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums = {1, 1, 1, 1, 2};
//        int[] nums = {1,2,3,4,5,6,7,8,9,9,9,10};
        LeetCode26 leetCode26 = new LeetCode26();
//        int i = leetCode26.removeDuplicates(nums);
//        System.out.println(Arrays.toString(nums));
        System.out.println(leetCode26.isPerfectSquare(808201));
    }

/*
        public int removeDuplicates(int[] nums) {
            int head = 0, tail = 1;
            if (nums != null) {
                while (tail < nums.length) {
                    while (nums[head] == nums[tail] && tail < nums.length - 1) {
                        tail++;
                    }
                    if (nums[head] != nums[tail]){
                        head++;
                        nums[head] = nums[tail];
                    }
                    tail++;
                }
            }
            return head+1;
        }
*/
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public boolean isPerfectSquare(int num) {
        if (num < 0)
            return false;
        if (num == 1)
            return true;
        int circle = num / 2;
        for (int i = 1; i <= circle; i++) {
            int sum = i * i;
            int bigsize = sum * sum;
            if (sum == num)
                return true;
            else if (sum > num)
                return false;
            else if (bigsize > num) {
                circle = bigsize;
            }
        }
        return false;
    }
}
