package com.Hxin.offerTest.tencent2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/15 20:13
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] arrays = new long[n];
        for (int i = 0; i < n; i++) {
            arrays[i] = sc.nextLong();
        }
        Arrays.sort(arrays);
        int index = 0;
        for (int i = 0; i < k; i++) {
            if (index + 1 < n && arrays[index] > arrays[index + 1]) {
                index += 1;
            }
            if (arrays[index] % 2 == 1) {
                arrays[index] = arrays[index] * 2L;
            } else {
                arrays[index] = arrays[index] * 2L + 1L;
            }
        }
        long ans = 0L;
        for (long array : arrays) {
            ans += array;
        }
        System.out.println(ans);
    }
}
