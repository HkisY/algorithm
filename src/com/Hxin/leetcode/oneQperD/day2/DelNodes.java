package com.Hxin.leetcode.oneQperD.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给出二叉树的根节点root，树上每个节点都有一个不同的值。
 * 如果节点值在to_delete中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 * <p>
 * 示例 2：
 * 输入：root = [1,2,4,null,3], to_delete = [3]
 * 输出：[[1,2,4]]
 * <p>
 * 链接：https://leetcode.cn/problems/delete-nodes-and-return-forest
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/30 21:07
 */
public class DelNodes {
    static List<TreeNode> leftNode = new ArrayList<>();
    static List<TreeNode> rightNode = new ArrayList<>();


    private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>();
        for (int num : to_delete) {
            numSet.add(num);
        }
        deleteNodeByDFS(result, numSet, root,true);

        return result;
    }

    private static TreeNode deleteNodeByDFS(List<TreeNode> result, Set<Integer> numSet, TreeNode root,boolean isTreeNode) {
        if (root == null) {
            return null;
        }
        boolean deleted = numSet.contains(root.val);
        //传入的deleted作为下一个dfs判断父节点是否删除的标志
        root.left = deleteNodeByDFS(result, numSet, root.left,deleted);
        root.right = deleteNodeByDFS(result, numSet, root.right,deleted);
        if (deleted) {
            return null;
        }else {
            //判断此节点的父节点是否是需要删除的，如果是则将此节点加入结果集
            if (isTreeNode){
                result.add(root);
            }
            return root;
        }
    }

    /**
     * 获得被寻找节点的父节点
     *
     * @param node 根节点
     * @param num  被查询数字
     */
    private static void findNode(TreeNode node, int num, int numLayer) {
        if (node.left != null && node.left.val == num) {
            TreeNode addNode = new TreeNode(numLayer);
            addNode.left = node;
            leftNode.add(addNode);
        }
        if (node.right != null && node.right.val == num) {
            TreeNode addNode = new TreeNode(numLayer);
            addNode.right = node;
            rightNode.add(addNode);
        }
        if (node.left != null || node.right != null) {
            if (node.left != null && node.right == null) {
                findNode(node.left, num, numLayer + 1);
            }
            if (node.right != null && node.left == null) {
                findNode(node.right, num, numLayer + 1);
            }
            if (node.left != null && node.right != null) {
                findNode(node.left, num, numLayer + 1);
                findNode(node.right, num, numLayer + 1);
            }
        }
    }

    private static int treeDepth(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 1;
        } else if (node.left == null) {
            return treeDepth(node.right) + 1;
        } else if (node.right == null) {
            return treeDepth(node.left) + 1;
        } else {
            return Math.max(treeDepth(node.left), treeDepth(node.right)) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode r2 = new TreeNode(5);
        TreeNode l2 = new TreeNode(4);
        TreeNode r3 = new TreeNode(7);
        TreeNode l3 = new TreeNode(6);
        TreeNode l1 = new TreeNode(2, l2, r2);
        TreeNode r1 = new TreeNode(3, l3, r3);
        TreeNode root = new TreeNode(1, l1, r1);
        System.out.println(root);
        int[] nums = {3, 5};
        System.out.println(delNodes(root, nums));
    }
}
