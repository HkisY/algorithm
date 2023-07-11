package com.Hxin.dataStructure.chapter2.listADT.arrayList;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/6
 */
public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private T[] theItems;

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public T get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    //返回旧的值
    public T set(int idx, T newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity) {
        //正常调用ensureCapacity，theSize必为0；此处防止违规访问
        if (newCapacity < theSize) {
            return;
        }
        T[] old = theItems;
        theItems = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, T x) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;
        theSize++;
    }

    public T remove(int idx) {
        T removeItem = theItems[idx];
        for (int i = idx; i < size(); i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return removeItem;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    public ListIterator<T> listIterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements ListIterator<T> {
        boolean backwards = false;
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException();
            backwards = false;
            return theItems[current++];
        }

        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public T previous() {
            if (!hasPrevious())
                throw new java.util.NoSuchElementException();
            backwards = true;
            return theItems[--current];
        }

        @Override
        public int nextIndex() {
            int index = current;
            if (!hasNext())
                return -1;
            else
                return index + 1;
        }

        @Override
        public int previousIndex() {
            int index = current;
            if (!hasPrevious())
                return -1;
            else
                return index - 1;
        }

        @Override
        public void remove() {
            if (backwards)
                MyArrayList.this.remove(current--);
            else
                MyArrayList.this.remove(--current);
        }

        @Override
        public void set(T t) {
            MyArrayList.this.set(current, t);
        }

        @Override
        public void add(T t) {
            MyArrayList.this.add(current++, t);
        }
    }

    private class ArrayListIterator implements Iterator<T> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
