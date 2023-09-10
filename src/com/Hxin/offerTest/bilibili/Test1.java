package com.Hxin.offerTest.bilibili;

import java.util.Arrays;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/9 19:35
 */
public class Test1 {
    public static int subArrNum(int[] arr) {
        Arrays.sort(arr);
        int ans = arr.length;
        // write code here
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] > 2) {
                    break;
                } else {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1,5,7,4,9};
        subArrNum(arr);
    }
}
