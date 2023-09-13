package com.Hxin.offerTest.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/10 21:36
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] source = new int[length];
        int k = in.nextInt();
        for (int i = 0; i < length; i++) {
            source[i] = in.nextInt();
        }
//        10^9
        Arrays.sort(source);
        int ans = 0;
        int[] dp = new int[k];
        String[] binaryStr = new String[length];
        for (int i = 0; i < length; i++) {
            binaryStr[i] = Integer.toBinaryString(source[i]);
        }

    }
}
