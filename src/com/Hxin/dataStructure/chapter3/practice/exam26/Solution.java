package com.Hxin.dataStructure.chapter3.practice.exam26;

import com.Hxin.dataStructure.chapter3.AVLTree.AvlTree;

import static java.lang.Math.max;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/25
 */
public class Solution extends AvlTree {
    static AvlNode doubleRotateWithLeft(AvlNode k3) {
        AvlNode k1, k2;

        k1 = k3.left;
        k2 = k1.right;

        k1.right = k2.left;
        k3.left = k2.right;
        k2.left = k1;
        k2.right = k3;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k3.height = max(height(k3.left), height(k3.right)) + 1;
        k2.height = max(k1.height, k3.height) + 1;

        return k3;
    }
}
