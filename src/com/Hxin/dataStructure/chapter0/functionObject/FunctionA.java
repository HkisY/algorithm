package com.Hxin.dataStructure.chapter0.functionObject;

import java.util.Comparator;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/2
 */
public class FunctionA<T> {
    private T val;

    public T read() {
        return val;
    }

    public void write(T val) {
        this.val = val;
    }

    public static <T> T findMax(T[] arr, Comparator<? super T> cmp) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++)
            if (cmp.compare(arr[i], arr[maxIndex]) > 0)
                maxIndex = i;
        return arr[maxIndex];
    }
}
