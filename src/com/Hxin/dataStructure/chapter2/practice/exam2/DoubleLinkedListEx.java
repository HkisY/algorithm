package com.Hxin.dataStructure.chapter2.practice.exam2;

/**
 * 双链表
 *
 * @author Hxin
 * @version 1.0
 * @since 2022/4/7
 */
public class DoubleLinkedListEx<T> {
    private int theSize;
    private int modCount = 0;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    public DoubleLinkedListEx() {
        doClear();
    }

    public static void main(String[] args) {
        DoubleLinkedListEx<Integer> list = new DoubleLinkedListEx<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.print("\n");
        list.exchangeBack(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
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

    public void exchangeBack(int idx) {
        if (idx > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = getNode(idx);

        node.next.next.pre = node;
        node.next.pre = node.pre;
        node.pre = node.next;


//        node.next.pre.next = node.next;
//        node.next = node.next.next;
//        node.pre.next = node;
        node.pre.pre.next = node.pre;
        node.pre.next = node.next;
        node.pre.next = node;

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
}
