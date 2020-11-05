package com.datastructure.leetcode;

/**
 * @author dzl
 * 2020/10/27 9:23
 * @Description
 */
public class LeetCode112 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        LeetCode112 leetCode112 = new LeetCode112();
        boolean b = leetCode112.hasPathSum(treeNode, 22);
        System.out.println(b);


    }


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int count = sum - root.val;
        if (root.left == null && root.right == null) {
            return count == 0;
        }
        return hasPathSum(root.left, count) || hasPathSum(root.right, count);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

}
