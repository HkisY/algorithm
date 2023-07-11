package com.Hxin.dataStructure.chapter4.quadraticProbing;

import java.util.Arrays;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/5/18
 */
public class QuadraticProbingHashTable<T> {
    private static final int DEFAULT_TABLE_SIZE = 12;
    private HashEntry<T>[] array;
    private int currentSize;

    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
    }

    private static int nextPrime(int n) {
        //return next prime
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    private static boolean isPrime(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void makeEmpty() {
        currentSize = 0;
        Arrays.fill(array, null);
    }

    public boolean contains(T t) {
        int currentPos = findPos(t);
        return isActive(currentPos);
    }

    public void insert(T t) {
        int currentPos = findPos(t);
        if (isActive(currentPos)) return;
        array[currentPos] = new HashEntry<>(t);
        if (currentSize > array.length / 2) {
            rehash();
        }
    }

    public void remove(T t) {
        int currentPos = findPos(t);
        if (isActive(currentPos)) {
            array[currentPos].isActive = false;
        }
    }

    @SuppressWarnings("unchecked")
    private void allocateArray(int arraySize) {
        array = new HashEntry[nextPrime(arraySize)];
    }

    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }

    private int findPos(T t) {
        int offSet = 1;
        int currentPos = myHash(t);
        while (array[currentPos] != null && !array[currentPos].element.equals(t)) {
            currentPos += offSet;
            offSet += 2;
            if (currentPos >= array.length) {
                currentPos -= array.length;
            }
        }
        return currentPos;
    }

    private void rehash() {
        HashEntry<T>[] oldArray = array;
        allocateArray(nextPrime(2 * oldArray.length));
        currentSize = 0;
        for (HashEntry<T> tHashEntry : oldArray) {
            if (tHashEntry != null && tHashEntry.isActive) {
                insert(tHashEntry.element);
            }
        }
    }

    private int myHash(T t) {
        int hashVal = t.hashCode();
        hashVal %= array.length;
        if (hashVal < 0)
            hashVal += array.length;
        return hashVal;
    }

    private static class HashEntry<T> {
        public T element;
        public boolean isActive;    //false if marked deleted

        public HashEntry(T e) {
            this(e, true);
        }

        public HashEntry(T e, boolean i) {
            element = e;
            isActive = i;
        }
    }

}
