package com.Hxin.dataStructure.chapter0.practice.Exam14;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/4
 */
public class OrderedCollection<T extends Comparable> {
    private Object[] arr;
    private int num;
    private final static int INIT_SIZE = 10;

    OrderedCollection() {
        this.arr = new Object[INIT_SIZE];
    }

    //自动扩容
    public void autoIncreaseCapacity() {
        Object[] newArr = new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        this.arr = newArr;
    }

    public boolean isEmpty() {
        return num == 0;
    }

    public boolean makeEmpty() {
        for (int i = 0, arrLength = arr.length; i < arrLength; i++) {
            arr[i] = null;
        }
        num = 0;
        return true;
    }

    public void insert(T t) {
        for (int i = 0, arrLength = arr.length; i < arrLength; i++) {
            if (arr[i] == null) {
                arr[i] = t;
                num++;
                break;
            }
        }
    }

    public boolean remove(T t) {
        for (int i = 0; i < num; i++) {
            if (Objects.equals(arr[i], t)) {
                arr[i] = null;
                System.arraycopy(arr, i + 1, arr, i, num - i);
                num--;
                return true;
            }
        }
        return false;
    }

    public Object findMin() {
        Object[] temp = new Object[num];
        System.arraycopy(arr, 0, temp, 0, num);
        Arrays.sort(temp);
        return temp[0];
    }

    public Object findMax() {
        Object[] temp = new Object[num];
        System.arraycopy(arr, 0, temp, 0, num);
        Arrays.sort(temp);
        return temp[num - 1];
    }
}
