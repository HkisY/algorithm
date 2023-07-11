package com.Hxin.dataStructure.chapter2.practice.exam32;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/11
 */
public class SingleLinkedQueue<T> {

    private Node<T> front, rear;

    SingleLinkedQueue() {
        front = null;
        rear = null;
    }

    void enqueue(T x) {
        Node<T> p = new Node<T>(x, null);
        if (rear != null)
            rear = rear.next = p;
        else
            front = rear = p;
    }

    T dequeue() {
        T temp = front.data;
        Node<T> p = front;
        if (front.next == null)    // only 1 node
            front = rear = null;
        else
            front = front.next;
        return temp;
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
