package com.Hxin.dataStructure.chapter2.practice.exam31;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/11
 */
public class SingleLinkedStack<T> {
    private Node<T> head;

    SingleLinkedStack() {
        head = null;
    }

    void push(T x) {
        Node<T> p = new Node<>(x, head);
        head = p;
    }

    T top() {
        return head.data;
    }

    void pop() {
        head = head.next;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node() {
            this(null, null);
        }

        Node(T x) {
            this(x, null);
        }
        Node(T x, Node<T> p) {
            data = x;
            next = p;
        }
    }
}
