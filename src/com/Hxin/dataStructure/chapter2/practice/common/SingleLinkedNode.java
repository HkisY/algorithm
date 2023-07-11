package com.Hxin.dataStructure.chapter2.practice.common;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/8
 */
public class SingleLinkedNode<T> {
    private T data;
    private SingleLinkedNode<T> next;

    public SingleLinkedNode() {
    }

    public SingleLinkedNode(T data) {
        this.data = data;
    }

    public SingleLinkedNode(T data, SingleLinkedNode<T> next) {
        this.data = data;
        this.next = next;
    }
}
