package com.Hxin.dataStructure.chapter2.practice.exam2;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/7
 */
//singleLinkedList   exam 11
public class SingleLinkedListEx<T> {
    private Node<T> headNode = new Node<>();
    private int num = 0;

    SingleLinkedListEx() {
        doClear();
    }

    // beforeP is the cell before the two adjacent cells that are to be swapped.
    // Error checks are omitted for clarity.
    public static void swapWithNext(Node beforep) {
        Node p, afterp;

        p = beforep.next;
        afterp = p.next;    // Both p and afterp assumed not null.

        p.next = afterp.next;
        beforep.next = afterp;
        afterp.next = p;
    }

    public static void main(String[] args) {
        SingleLinkedListEx<Integer> list = new SingleLinkedListEx<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(12);
        list.add(24);
        list.add(2, 444);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print("\n");
        list.exchangeBack(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }

    public void doClear() {
        num = 0;
        headNode.next = null;
    }

    public void makeEmpty() {
        doClear();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return num;
    }

    public void set(int idx, T data) {
        getNode(idx).data = data;
    }

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (size() == 0) {
            headNode.next = node;
            num++;
            return;
        }
        getNode(size() - 1).next = node;
        num++;
    }

    public void add(int idx, T data) {
        if (idx > num - 1 || idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = headNode;
        Node<T> target = new Node<>(data);
        if (idx == 0) {
            target.next = headNode.next;
            headNode.next = target;
            return;
        }
        for (int i = 0; i < idx; i++) {
            //插入节点前一个节点
            node = node.next;
        }
        target.next = node.next;
        node.next = target;
        num++;
    }



    public T get(int idx) {
        return getNode(idx).data;
    }

    public void exchangeBack(int idx) {
        if (idx == size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        final Node<T> sourceNode = getNode(idx);
        final Node<T> targetNode = sourceNode.next;
        final Node<T> preNode = getPreNode(idx);

        sourceNode.next = targetNode.next;
        preNode.next = targetNode;
        targetNode.next = sourceNode;
    }

    private Node<T> getPreNode(int idx) {
        if (idx > num - 1 || idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = headNode;
        if (idx == 0) {
            return node;
        }
        for (int i = 0; i < idx; i++) {
            node = node.next;
        }
        return node;
    }

    private Node<T> getNode(int idx) {
        if (idx > num - 1 || idx < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = headNode;
        for (int i = 0; i <= idx; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        Node() {
        }

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
}
