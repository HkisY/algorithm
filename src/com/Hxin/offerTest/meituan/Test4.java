package com.Hxin.offerTest.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/8/26 10:58
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queryTime = sc.nextInt();
        int m = 0, n = 0;
        for (int i = 0; i < queryTime; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            int[] arrayA = new int[n];
            int[] arrayB = new int[n];
            for (int k = 0; k < n; k++) {
                arrayA[k] = sc.nextInt();
            }
            for (int k = 0; k < n; k++) {
                arrayB[k] = sc.nextInt();
            }
            String s = queryYesOrNo(arrayA,arrayB,m);
            System.out.println(s);
        }
    }

    private static String queryYesOrNo(int[] arrayA, int[] arrayB, int m) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = arrayA[i]+arrayB[arrayA.length-1-i];
        }
        for (int j : arrayA) {
            if (j > m) {
                return "No";
            }
        }
        return "Yes";
    }

}
