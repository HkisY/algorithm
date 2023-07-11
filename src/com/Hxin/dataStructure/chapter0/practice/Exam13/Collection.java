package com.Hxin.dataStructure.chapter0.practice.Exam13;

import java.util.Arrays;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/2
 */
public class Collection<T> {

    private Object[] arr;


    private final static int INIT_SIZE = 3;


    public Collection() {
        this.arr = new Object[INIT_SIZE];
    }

    private int num = 0;

    //自动扩容
    public void autoIncreaseCapacity() {
        Object[] newArr = new Object[arr.length * 2];
        for (int i = 0;i< arr.length;i++){
            newArr[i] = arr[i];
        }
        this.arr = newArr;
    }

    public boolean isEmpty() {
        return num == 0;
    }

    public boolean makeEmpty() {
        for (int i = 0; i < num; i++) {
            arr[i] = null;
        }
        num = 0;
        return true;
    }

    public boolean insert(T t) {
        if (num == arr.length - 1) {
            autoIncreaseCapacity();
        }
        arr[num++] = t;
        return true;
    }

    public boolean remove(T t) {
        for (int i = 0; i < num; i++) {
            if (arr[i].equals(t)) {
                arr[i] = null;
                System.arraycopy(arr, i + 1, arr, i, num - i);
                num--;
                return true;
            }
        }
        return false;
    }

    public boolean isPresent(T t) {
        for (int i = 0; i < num; i++) {
            if (arr[i].equals(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "arr=" + Arrays.toString(arr) +
                ", num=" + num +
                '}';
    }
}
