package com.Hxin.dataStructure.chapter2.listADT.linkedList;

import java.util.Iterator;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/6
 */
public class LinkedListByMe<T> {
    private static int num = 0;
    private Node startNode = new Node(null, null, null);
    private Node endNode = new Node(null, null, null);

    LinkedListByMe() {
        startNode.next = endNode;
        endNode.pre = startNode;
    }


    public void remove(int idx) {
        if (idx > num || idx < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node removeNode = startNode;
        for (int i = 0; i <= idx; i++) {
            removeNode = removeNode.next;
        }

        removeNode.pre.next = removeNode.next;
        removeNode.next.pre = removeNode.pre;
        num--;
    }

    public T get(int idx) {
        Node node = startNode;
        for (int i = 0; i <= idx; i++) {
            node = node.next;
        }
        return node.t;
    }

    public void add(T t) {
        num++;
        Node node = new Node();
        node.t = t;


        node.next = endNode;
        node.pre = endNode.pre;

        endNode.pre.next = node;
        endNode.pre = node;

    }

    public void add(int idx, T t) {
        Node addNode = new Node(t, null, null);
        if (idx > num || idx < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node targetNode = startNode;
        for (int i = 0; i <= idx; i++) {
            targetNode = targetNode.next;
        }

        addNode.next = targetNode;
        addNode.pre = targetNode.pre;


        targetNode.pre.next = addNode;
        targetNode.pre = addNode;

        num++;
    }

    public int size() {
        return num;
    }

    private class Node {
        private T t;
        private Node pre;
        private Node next;

        Node() {
        }

        Node(T t, Node pre, Node next) {
            this.t = t;
            this.pre = pre;
            this.next = next;
        }
    }

    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private int current;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            return get(current++);
        }

        @Override
        public void remove() {
            LinkedListByMe.this.remove(--current);
        }
    }


}
