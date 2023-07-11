package com.Hxin.dataStructure.chapter1.practice.exam32;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/5
 */
public class BinarySearch {
    private static final int NOT_FOUND = -1;

    /**
     * 折半查找，寻找数组元素值与目标值相等的数组下标,三路比较
     *
     * @param a   T[]
     * @param x   target value
     * @param <T> T
     * @return int
     */
    public static <T extends Comparable<? super T>> int binarySearch(T[] a, T x) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else return mid;
        }
        return NOT_FOUND;
    }


    /**
     * 折半查找，寻找数组元素值与目标值相等的数组下标,二路比较(存疑。。。。)
     *
     * @param a   T[]
     * @param x   target value
     * @param <T> T
     * @return int
     */
    public static <T extends Comparable<? super T>> int binarySearchByTwoCompared(T[] a, T x) {
        int low = 0, high = a.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid].compareTo(x) == 0) {
                return mid;
            }
            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else {
                high = mid + 1;
            }
        }
        return NOT_FOUND;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 7, 9, 11, 42, 57, 89, 111, 1124};
        System.out.println(binarySearch(arr, 7));
        System.out.println(binarySearchByTwoCompared(arr, 7));

    }
}
