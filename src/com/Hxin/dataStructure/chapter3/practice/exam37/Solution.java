package com.Hxin.dataStructure.chapter3.practice.exam37;


/**
 * This is known as one-dimensional range searching. The time is O(K) to perform the inorder traversal,
 * if a significant number of nodes are found, and also proportional to the depth of the tree, if we get to some
 * leaves (for instance, if no nodes are found). Since the average depth is O(log N), this gives an O(K + log N) average bound.
 *
 * @author Hxin
 * @version 1.0
 * @since 2022/5/17
 */
public class Solution<T extends Comparable<? super T>> {

    void printRange(T lower, T upper, BinaryNode<T> t) {
        if (t != null) {
            if (lower.compareTo(t.element) <= 0) printRange(lower, upper, t.left);
            if (lower.compareTo(t.element) <= 0 && t.element.compareTo(upper) <= 0)
                System.out.println(t.element);
            if (t.element.compareTo(upper) <= 0) printRange(lower, upper, t.right);
        }
    }

    static class BinaryNode<T> {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;
        BinaryNode(){}

        BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right){
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}
