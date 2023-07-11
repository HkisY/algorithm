package com.Hxin.dataStructure.chapter2.practice.exam28;

import java.util.Arrays;

/**
 * Using double linkedList is very simple, The implementation of this class uses array
 * @author Hxin
 * @version 1.0
 * @since 2022/4/11
 */
public class ArrayDequeByMe<T> {
    private final static int INIT_CAPACITY = 10;
    private int theSize;
    private T[] theItems;
    private int startQueen;
    private int endQueen;
    //用于记录队尾离容量上限之间的距离
    private int endFlag;

    public ArrayDequeByMe() {
        doClear();
    }

    public static void main(String[] args) {
        ArrayDequeByMe<Integer> deque = new ArrayDequeByMe<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        System.out.println(deque);
        deque.inject(5);
        deque.inject(6);
        deque.inject(7);
        deque.inject(8);
        System.out.println(deque);

        System.out.println(deque.pop());
        System.out.println(deque);
        System.out.println(deque.eject());
        System.out.println(deque);
        deque.push(4);
        System.out.println(deque);
        deque.inject(8);
        System.out.println(deque);
    }

    public void clear() {
        doClear();
    }

    public int size() {
        return theSize;
    }

    private void doClear() {
        startQueen = 0;
        theSize = 0;
        endQueen = theSize;
        endEnsureCapacity(INIT_CAPACITY);
        endFlag = INIT_CAPACITY;
    }

    private void endEnsureCapacity(int newCapacity) {
        //正常调用ensureCapacity，theSize必为0；此处防止违规访问
        if (newCapacity < theSize) {
            return;
        }
        T[] old = theItems;
        int num = size();
        theItems = (T[]) new Object[newCapacity];

        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
        endFlag = newCapacity - size();
    }

    private void startEnsureCapacity(int newCapacity) {
        //正常调用ensureCapacity，theSize必为0；此处防止违规访问
        if (newCapacity < theSize) {
            return;
        }
        T[] old = theItems;
        int num = old.length;
        theItems = (T[]) new Object[newCapacity];

        startQueen = newCapacity - num;

        for (int i = 0; i < size(); i++) {
            theItems[startQueen++] = old[i];
        }
        startQueen = newCapacity - num;
        endQueen = newCapacity - num + 1;
    }

    public void push(T t) {
        if (startQueen == 0) {
            startEnsureCapacity(INIT_CAPACITY * 2);
        }
        theSize++;
        theItems[startQueen--] = t;
    }

    public void inject(T t) {
        if (endFlag == 0) {
            endEnsureCapacity(INIT_CAPACITY * 2);
        }
        theSize++;
        endFlag--;
        theItems[endQueen++] = t;
    }

    public T pop() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException();
        }
        theSize--;
        T result = theItems[++startQueen];
        theItems[startQueen] = null;
        return result;
    }

    public T eject() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException();

        }
        theSize--;
        T result = theItems[--endQueen];
        theItems[endQueen] = null;
        return result;
    }

    @Override
    public String toString() {
        return "ArrayDequeByMe{" +
                "theSize=" + theSize +
                ", theItems=" + Arrays.toString(theItems) +
                ", startQueen=" + startQueen +
                ", endQueen=" + endQueen +
                ", endFlag=" + endFlag +
                '}';
    }
}
