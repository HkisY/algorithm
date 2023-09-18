package com.Hxin.offerTest.tencent2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/15 20:33
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int t = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = a[i] + b[i] * t;
        }
        int ans = 0;
//        TODO 排名相同
        HashMap<Integer, Integer> originMap = new HashMap<>();
        for (int i = 0; i < c.length; i++) {
            originMap.put(c[i], i);
        }
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : originMap.entrySet()) {
            final Integer value = entry.getValue();
            if (value <= index) {
                ans++;
            }
            index++;
        }
        System.out.println(ans);
    }
}
