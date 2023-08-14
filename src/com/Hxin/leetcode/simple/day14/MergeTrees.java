package com.Hxin.leetcode.simple.day14;

/**
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：
 * 如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * <p>
 * 注意: 合并过程必须从两个树的根节点开始。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/14 19:25
 */
public class MergeTrees {

    public static void main(String[] args) {
        //输出要求层级遍历
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        System.out.println(mergeTreesThroughRoot(root1, root2));
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeTreesThroughRoot(root1, root2);
    }

    public static TreeNode mergeTreesThroughRoot(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        TreeNode resRoot = new TreeNode();
        resRoot.val = root1.val + root2.val;
        resRoot.left = mergeTreesThroughRoot(root1.left, root2.left);
        resRoot.right = mergeTreesThroughRoot(root1.right, root2.right);
        return resRoot;
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
