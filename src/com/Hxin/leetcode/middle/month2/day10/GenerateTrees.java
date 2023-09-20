package com.Hxin.leetcode.middle.month2.day10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/19  16:49
 */
public class GenerateTrees {
    private static final List<TreeNode> ans = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }

    public static List<TreeNode> generateTrees(int n) {
//        二叉搜索树
        for (int i = 1; i <= n; i++) {
            int[] flag = new int[n+1];
            flag[i] = 1;
            TreeNode root = new TreeNode(i);
            TreeNode head = new TreeNode(-1);
            head.left = root;
            dfs(1, n, root, flag,head);
        }
        return ans;
    }

    private static void dfs(int count, int n, TreeNode root, int[] flag,TreeNode head) {
        if (count == n) {
            ans.add(head.left);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (flag[i] == 1) continue;
            TreeNode node = new TreeNode(i);
            flag[i] = 1;
            if (i > root.val) {
                root.right = node;
                dfs(count + 1, n, node, flag,head);
            } else {
                root.left = node;
                dfs(count + 1, n, node, flag,head);
            }
            flag[i] = 0;
        }
    }
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    public static class TreeNode {
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
    }
}
