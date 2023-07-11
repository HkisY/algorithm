package com.Hxin.dataStructure.chapter3.practice.exam35;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/5/17
 */
public class Solution {
    static Node genTree(int height, int[] lastNode) {
        Node t = null;
        if (height >= 0) {
            t = new Node();
            t.left = genTree(height - 1, lastNode);
            t.data = ++lastNode[0];
            t.right = genTree(height - 2, lastNode);
        }
        return t;
    }

    static Node minAvlTree(int height) {
        int[] lastNodeAssigned = {0};
        return genTree(height, lastNodeAssigned);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node() {
        }

        Node(int num, Node left, Node right) {
            this.data = num;
            this.left = left;
            this.right = right;
        }
    }
}
