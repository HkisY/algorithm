package com.Hxin.dataStructure.chapter3.binaryTree;

import java.util.Stack;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/13
 */
public class ExpressionTree {
    public static void main(String[] args) {
        Stack<Node<Character>> stack = new Stack<>();
        String expression = "ab+cde+**";
        char[] chars = expression.toCharArray();
        for (char c : chars) {
            if (c != '+' && c != '-' && c != '*' && c != '/') {
                stack.push(new Node<>(c));
            } else {
                Node<Character> node = new Node<>(c, stack.pop(), stack.pop());
                stack.push(node);
            }
        }

        System.out.println(stack);
    }

    static class Node<T> {
        T t;
        Node<T> left;
        Node<T> right;

        Node(T t) {
            this(t, null, null);
        }

        Node(T t, Node<T> right, Node<T> left) {
            this.left = left;
            this.t = t;
            this.right = right;
        }
    }
}
