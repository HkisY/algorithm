package com.Hxin.offerTest.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/8/26 10:34
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int optTime = sc.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = sc.nextInt();
        }
//        int[] array = {1, 2, 3, 4, 5};
//        int optTime = 3;

        final int mod = 100000000 + 7;
        Arrays.sort(array);
        for (int i = array.length - 1; i > array.length - 1 - optTime; i--) {
            int tempMax = array[i] * array[i - 1];
            tempMax = tempMax % mod;
            array[i] = 1;
            array[i - 1] = tempMax;
        }
        int res = 0;
        for (int i : array) {
            res += i;
            res = res % mod;
        }
        System.out.println(res);
    }

    private static int solution(int[] array, int optTime) {
        final int mod = 100000000 + 7;
        Arrays.sort(array);
        for (int i = array.length - 1; i > array.length - 1 - optTime; i--) {
            int tempMax = array[i] * array[i - 1];
            tempMax = tempMax % mod;
            array[i] = 1;
            array[i - 1] = tempMax;
        }
        int res = 0;
        for (int i : array) {
            res += i;
            res = res % mod;
        }
        return res;
    }
}
