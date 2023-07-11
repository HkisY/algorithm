package com.Hxin.dataStructure.chapter2.listADT.arrayList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/6
 */
public class ArrayListByMe<T> {
    private final static int INIT_CAPACITY = 10;
    private T[] arr;
    private int num;
    private final Iterator<T> iterator = new Iterator<T>() {

        private int current = 0;
        @Override
        public boolean hasNext() {
            return current < num;
        }

        @Override
        public T next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            return arr[current++];
        }

        @Override
        public void remove(){
            ArrayListByMe.this.remove(--current);
        }
    };

    ArrayListByMe() {
        arr = (T[])new Object[INIT_CAPACITY];
    }

    public Iterator<T> iterator(){
        return iterator;
    }

    public void ensureCapacity() {
        if (num == INIT_CAPACITY) {
            T[] newArr = (T[])new Object[INIT_CAPACITY * 2];
            System.arraycopy(arr, 0, newArr, 0, num);
            this.arr = newArr;
        }
    }

    public Object get(int index) {
        return arr[index];
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num == 0;
    }

    public void clear() {
        num = 0;
        arr = (T[])new Object[INIT_CAPACITY];
    }

    public T remove(int idx) {
        T removeItem = arr[idx];
        if (size() - idx >= 0) System.arraycopy(arr, idx + 1, arr, idx, size() - idx);
        num--;
        return removeItem;
    }

    public boolean add(T t) {
        if (num == arr.length) {
            ensureCapacity();
        }
        arr[num++] = t;
        return true;
    }

}
