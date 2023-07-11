package com.Hxin.dataStructure.chapter4.cuckoo;

import com.Hxin.dataStructure.chapter4.HashFamily;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/5/19
 */
public class CuckooHashTable<T> {
    private static final double MAX_LOAD = 0.4;//装填因子
    private static final int ALLOWED_REHASHES = 1;
    private static final int DEFAULT_TABLE_SIZE = 101;
    //HashFamily
    private final HashFamily<? super T> hashFunctions;
    private final int numHashFunctions;
    //main Val
    private T[] array;
    private int currentSize;
    //insertHelperHandler
    private int reHashes = 0;
    private final Random r = new Random();

    public CuckooHashTable(HashFamily<? super T> hashFamily) {
        this(hashFamily, DEFAULT_TABLE_SIZE);
    }

    public CuckooHashTable(HashFamily<? super T> hashFamily, int size) {
        allocateArray(nextPrime(size));
        doClear();
        hashFunctions = hashFamily;
        numHashFunctions = hashFamily.getNumberOfFunctions();
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
        doClear();
    }

    public boolean contains(T t) {
        return findPos(t) != -1;
    }

    public boolean remove(T t) {
        int pos = findPos(t);
        if (pos != -1) {
            array[pos] = null;
            currentSize--;
        }
        return pos != -1;
    }

    public boolean insert(T t) {
        if (contains(t)) {
            return false;
        }
        if (currentSize >= array.length * MAX_LOAD) {
            expand();
        }
        return insertHelperHandler(t);
    }

    private boolean insertHelperHandler(T t) {
        final int COUNT_LIMIT = 100;
        while (true) {
            int lastPos = -1;
            int pos;
            for (int count = 0; count < COUNT_LIMIT; count++) {
                for (int i = 0; i < numHashFunctions; i++) {
                    pos = myHash(t, i);
                    if (array[pos] == null) {
                        array[pos] = t;
                        currentSize++;
                        return true;
                    }
                }
                //none of the spots are available.evict out a random one
                int i = 0;
                do {
                    pos = myHash(t, r.nextInt(numHashFunctions));
                } while (pos == lastPos && i++ < 5);
                T tmp = array[lastPos = pos];
                array[pos] = t;
                t = tmp;
            }
            if (++reHashes > ALLOWED_REHASHES) {
                expand();
                reHashes = 0;
            } else {
                rehash();
            }
        }
    }

    private int myHash(T t, int which) {
        int hashVal = hashFunctions.hash(t, which);
        hashVal %= array.length;
        if (hashVal < 0) {
            hashVal += array.length;
        }
        return hashVal;
    }

    private int findPos(T t) {
        for (int i = 0; i < numHashFunctions; i++) {
            int pos = myHash(t, i);
            if (array[pos] != null && array[pos].equals(t)) {
                return pos;
            }
        }
        return -1;
    }

    private void expand() {
        rehash((int) (array.length / MAX_LOAD));
    }

    private void rehash() {
        hashFunctions.generateNewFunctions();
        rehash(array.length);
    }

    private void rehash(int newLength) {
        T[] oldArray = array;
        allocateArray(nextPrime(newLength));
        currentSize = 0;
        for (T str : oldArray) {
            if (str != null) {
                insert(str);
            }
        }
    }

    private void doClear() {
        currentSize = 0;
        Arrays.fill(array, null);
    }

    @SuppressWarnings("unchecked")
    private void allocateArray(int arraySize) {
        array = (T[]) new Object[arraySize];
    }
}
