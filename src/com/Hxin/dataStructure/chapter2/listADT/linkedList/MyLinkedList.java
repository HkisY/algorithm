package com.Hxin.dataStructure.chapter2.listADT.linkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/6
 */
public class MyLinkedList<T> implements Iterable<T> {
    private int theSize;
    private int modCount = 0;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    public MyLinkedList() {
        doClear();
    }

    // p and afterp are cells to be switched.	Error checks as before.
    //exam2 doubleLinkedList standard answer
    public void swapWithNext(Node<T> p) {
        Node<T> beforep, afterp;

        beforep = p.pre;
        afterp = p.next;

        p.next = afterp.next;
        beforep.next = afterp;
        afterp.next = p;
        p.next.pre = p;
        p.pre = afterp;
        afterp.pre = beforep;
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, null, null);
        beginMarker.next = endMarker;
        endMarker.pre = beginMarker;
        theSize = 0;
        modCount++;
    }

    //exam3 standard answer
    public boolean contains(T x) {
        Node<T> p = beginMarker.next;
        while (p != endMarker && !(p.data.equals(x))) {
            p = p.next;
        }

        return (p != endMarker);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T t) {
        add(size(), t);
        return true;
    }

    public void add(int idx, T t) {
        addBefore(getNode(idx, 0, size()), t);
    }

    public T get(int idx) {
        return getNode(idx).data;
    }

    public T set(int idx, T newVal) {
        Node<T> node = getNode(idx);
        T oldVal = node.data;
        node.data = newVal;
        return oldVal;
    }

    public T remove(int idx) {
        return remove(getNode(idx));
    }


    private T remove(Node<T> node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
        theSize--;
        modCount++;
        return node.data;
    }

    private Node<T> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    private Node<T> getNode(int idx, int lower, int upper) {
        Node<T> p;
        if (idx < lower || idx > upper) {
            throw new IndexOutOfBoundsException();
        }
        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.pre;
            }
        }
        return p;
    }

    private void addBefore(Node<T> node, T t) {
        Node<T> newNode = new Node<>(t, node.pre, node);
        newNode.pre.next = newNode;
        node.pre = newNode;
        theSize++;
        modCount++;
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /*
    exam29
     */
    void reverseList() {
        Node<T> currentPos, nextPos, previousPos;

        previousPos = null;
        currentPos = beginMarker.next;    // skip header node nextPos = currentPos.next;
        nextPos = currentPos.next;

        while (nextPos != null) {
            currentPos.next = previousPos;
            previousPos = currentPos;
            currentPos = nextPos;
            nextPos = nextPos.next;
        }

        currentPos.next = previousPos;
        beginMarker.next = currentPos;
    }

    private static class Node<T> {
        public T data;
        public Node<T> pre;
        public Node<T> next;

        public Node(T t, Node<T> pre, Node<T> next) {
            data = t;
            this.pre = pre;
            this.next = next;
        }
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = beginMarker.next;
        //防止迭代器创建，并在遍历等操作中，在原集合上进行违规增删操作。
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!okToRemove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.pre);
            expectedModCount++;
            okToRemove = false;
        }
    }
}
