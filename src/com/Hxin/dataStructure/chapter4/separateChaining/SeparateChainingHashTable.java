package com.Hxin.dataStructure.chapter4.separateChaining;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/5/18
 */
public class SeparateChainingHashTable<T> {
    private static final int DEFAULT_TABLE_SIZE = 101;
    private List<T>[] theLists;
    private int currentSize;

    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    @SuppressWarnings("unchecked")
    public SeparateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
    }

    private static int nextPrime(int n) {
        //return next prime
        while (true) {
            if (isPrime(n++)) {
                break;
            }
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

    public void insert(T t) {
        List<T> whichList = theLists[myHash(t)];
        if (!whichList.contains(t)) {
            whichList.add(t);
            if (++currentSize > theLists.length) {
                rehash();
            }
        }
    }

    public void remove(T t) {
        List<T> whichList = theLists[myHash(t)];
        if (whichList.contains(t)) {
            whichList.remove(t);
            currentSize--;
        }
    }

    public boolean contains(T t) {
        List<T> whichList = theLists[myHash(t)];
        return whichList.contains(t);
    }

    public void makeEmpty() {
        for (List<T> theList : theLists) {
            theList.clear();
        }
        currentSize = 0;
    }

    public boolean isEmpty(){
        return currentSize==0;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        List<T>[] oldLists = theLists;
        theLists = new List[nextPrime(2 * theLists.length)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
        currentSize = 0;
        for (List<T> oldList : oldLists) {
            for (T t : oldList) {
                insert(t);
            }
        }
    }

    private int myHash(T t) {
        int hashVal = t.hashCode();
        hashVal %= theLists.length;
        if (hashVal < 0) {
            hashVal += theLists.length;
        }
        return hashVal;
    }

}
