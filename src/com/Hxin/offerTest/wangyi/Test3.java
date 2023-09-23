package com.Hxin.offerTest.wangyi;

import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/23 15:02
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        int out = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < j + i && j < len; j++) {
                out += i * arr[j] / (len - i + 1);
            }
        }
        System.out.println(out % (1000000000 + 7));
    }
}
