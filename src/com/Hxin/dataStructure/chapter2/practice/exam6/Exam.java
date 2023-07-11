package com.Hxin.dataStructure.chapter2.practice.exam6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/8
 */

public class Exam<T> implements Iterable<T> {
    private Node<T> beginNode;
    private int num;
    private int time;

    Exam() {
        doClear();
    }

    Exam(int time) {
        doClear();
        this.time = time;
    }

    //The standard answer
    public static void pass(int m, int n) {
        int i, j, mPrime, numLeft;
        ArrayList<Integer> L = new ArrayList<>();
        for (i = 1; i <= n; i++)
            L.add(i);

        ListIterator<Integer> iter = L.listIterator();
        Integer item = 0;

        numLeft = n;
        mPrime = m % n;

        for (i = 0; i < n; i++) {
            mPrime = m % numLeft;
            if (mPrime <= numLeft / 2) {
                if (iter.hasNext())
                    item = iter.next();
                for (j = 0; j < mPrime; j++) {
                    if (!iter.hasNext())
                        //init the iterator
                        iter = L.listIterator();
                    item = iter.next();
                }
            } else {
                for (j = 0; j < numLeft - mPrime; j++) {
                    if (!iter.hasPrevious())
                        iter = L.listIterator(L.size());
                    item = iter.previous();
                }
            }
            System.out.print("Removed " + item + " ");
            iter.remove();
            if (!iter.hasNext())
                iter = L.listIterator();

            System.out.println();
            for (Integer x : L)

                System.out.print(x + " ");
            System.out.println();
            numLeft--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //此题我的思路是对迭代器进行修改，同时设计一种符合此题的数据结构
        //N如果足够大，M不是很大的话，链表会好一点。
        //链表的结构并不好。。。。。数组可能会好一点
        //按照TODO修改后最坏时间复杂度为T(N*min(M,N))
        int N = 5;
        int M = 1;
        Exam<Integer> list = new Exam<>(M);
        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int result = iterator.next();
            System.out.print(result + " ");
        }
        pass(1,5);
    }

    public void doClear() {
        beginNode = new Node<>(null, null);
        num = 0;
    }

    public void add(T t) {
        final Node<T> node = getNode(size() - 1);
        node.next = new Node<>(t);
        num++;
    }

    public void remove(int idx) {
        final Node<T> node = getNode(idx - 1);
        node.next = node.next.next;
        num--;
    }

    private Node<T> getNode(int idx) {
        Node<T> node = beginNode;
        for (int i = 0; i <= idx; i++) {
            node = node.next;
        }
        return node;
    }

    public int size() {
        return num;
    }

    @Override
    public Iterator<T> iterator() {
        return new ExamIterator();
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private class ExamIterator implements Iterator<T> {
        int current = 0;
        int stopFlag = num;

        @Override
        public boolean hasNext() {
            return stopFlag != 1;
        }

        @Override
        public T next() {
            current += time;
            while (current >= size()) {
                current -= size();
            }

            /*
              TODO: 将前直节点单独取出来操作可进行优化。getNode 方法也可进行优化即记住上次寻找到的节点的位置进行遍历
             */
            T t = Exam.this.getNode(current).data;
            Exam.this.remove(current);
            stopFlag--;
            return t;
        }

    }
}
