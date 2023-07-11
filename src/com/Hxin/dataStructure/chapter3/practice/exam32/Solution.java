package com.Hxin.dataStructure.chapter3.practice.exam32;

/**
 * Have the recursive routine return a triple that consists of a boolean (whether the tree is a BST) and the minimum
 * and maximum items. Then a tree is a BST if it is empty or both subtrees are (recursively) BSTs, and the value in the
 * node lies between the maximum of the left subtree and the minimum of the right subtrees. Coding details are omitted.
 * @author Hxin
 * @version 1.0
 * @since 2022/4/27
 */
public class Solution<T extends Comparable<? super T>> {
    static class BinaryNode<T>{
        T data;
        BinaryNode<T> left;
        BinaryNode<T> right;
    }
    private boolean isBinarySearchTree(BinaryNode<T> node){

        return true;
    }
}
