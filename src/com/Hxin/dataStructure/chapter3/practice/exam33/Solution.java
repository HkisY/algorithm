package com.Hxin.dataStructure.chapter3.practice.exam33;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/27
 */
public class Solution {

    static Node removeLeaves(Node t) {
        if (t == null || (t.left == null && t.right == null)) return null;
        t.left = removeLeaves(t.left);
        t.right = removeLeaves(t.right);
        return t;
    }

    static class Node{
        Node left;
        Node right;
    }

}
