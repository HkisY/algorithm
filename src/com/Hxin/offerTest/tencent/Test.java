package com.Hxin.offerTest.tencent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/10 18:00
 */
public class Test {
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
//        {0,1,1,0,1,1,0}
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(0);
        TreeNode l2 = new TreeNode(1);
        TreeNode r2 = new TreeNode(0);
        TreeNode r1 = new TreeNode(0);
        TreeNode r3 = new TreeNode(1);
        root.left = l1;
        root.right = r1;
        root.left.left = l2;
        root.left.right = r2;
        root.right.right = r3;
        System.out.println(pathNumber(root));


    }

    public static int pathNumber(TreeNode root) {
        int ans = 0;
        dfs(root, 0);
        list.sort(Comparator.comparingInt(o -> o));
        for (int i = 1; i < list.size() - 1; i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) - list.get(i) == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void dfs(TreeNode root, int tempNum) {
        if (root.left == null && root.right == null) {
            list.add(tempNum);
        }
        if (root.left != null) {
            if (root.left.val == 1) {
                tempNum++;
            }
            dfs(root.left, tempNum);
        }
        if (root.right != null) {
            if (root.right.val == 1) {
                tempNum++;
            }
            dfs(root.right, tempNum);
        }
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
