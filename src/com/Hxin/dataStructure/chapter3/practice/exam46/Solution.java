package com.Hxin.dataStructure.chapter3.practice.exam46;

/**
 * don`t judge the node`s element,just look at whether the structs of the two trees are similar
 * @author Hxin
 * @version 1.0
 * @since 2022/5/17
 */
public class Solution {
    static boolean similar(BinaryNode t1, BinaryNode t2) {
        if (t1 == null || t2 == null)
            return t1 == null && t2 == null;
        return similar(t1.left, t2.left) && similar(t1.right, t2.right);
    }

    static class BinaryNode {
        int element;
        BinaryNode left;
        BinaryNode right;

        BinaryNode() {
        }

        BinaryNode(int element, BinaryNode left, BinaryNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}
