package com.Hxin.dataStructure.chapter4.practice.exam5;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/5/19
 */
public class Node<T> {
    protected T data;
    protected Node<T> next;

    public Node(T t) {
        this(t, null);
    }

    public Node(T t, Node<T> next) {
        data = t;
        this.next = next;
    }
}
