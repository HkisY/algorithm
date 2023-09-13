package com.Hxin.offerTest.baidu;

import java.util.*;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/12 19:38
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arrays = new int[n];
        for (int i = 0; i < n; i++) {
            arrays[i] = sc.nextInt();
        }
        int originIndex = -1, exIndex = -1;
        int start = 0;
        Set<Integer> set = new HashSet<>();
        int sum = k * (k + 1) / 2;
        for (int i = 0; i < k; i++) {
            set.add(i + 1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        Loop:
        for (int z = 0; z <= n - k; z++) {
            boolean tag = false;
            for (int i = z; i < z + k; i++) {
                if (set.contains(arrays[i])) {
                    sum -= arrays[i];
                } else {
                    if (!tag) {
                        originIndex = i + 1;
                        tag = true;
                    } else {
                        break Loop;
                    }
                }
            }
            if (sum == 0) {
                System.out.println("YES");
                System.out.println(z);
                return;
            }
            for (int i = 0; i < n; i++) {
                if (i >= start && i < start + k) {
                } else {
                    if (arrays[i] == sum) {
                        exIndex = i + 1;
                        break;
                    }
                }
            }
            if (originIndex!=-1&&exIndex!=-1){
                z = originIndex+1;
                map.put(originIndex, exIndex);
            }

            originIndex = -1;
            exIndex = -1;
            sum = k * (k + 1) / 2;
            tag = false;
            start++;
        }

        if (map.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(map.size());
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.print(entry.getKey() + " ");
                System.out.print(entry.getValue());
                System.out.println();
            }
        }
    }
}
