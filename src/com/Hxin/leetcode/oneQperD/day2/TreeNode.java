package com.Hxin.leetcode.oneQperD.day2;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/5/30 21:06
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "v=" + val +
                ", l=" + left +
                ", r=" + right +
                '}';
    }
}
