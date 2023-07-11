package com.Hxin.dataStructure.chapter2.practice.exam28;

import java.util.LinkedList;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/11
 */
public class LinkedDequeByMe<T> {
    LinkedList<T> L;

    LinkedDequeByMe() {
        L = new LinkedList<T>();
    }

    void push(T x) {
        L.addFirst(x);
    }

    T pop() {
        return L.removeFirst();
    }

    void inject(T x) {
        L.addLast(x);
    }

    T eject() {
        return L.removeLast();
    }
}
