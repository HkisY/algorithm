package com.Hxin.offerTest.wangyi;

import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/23 14:01
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loopTime = sc.nextInt();
        for (int i = 0; i < loopTime; i++) {
            int len = sc.nextInt();
            int[] array = new int[len];
            int[] sortedArray = new int[len];

            for (int j = 0; j < len; j++) {
                array[j] = sc.nextInt();
            }
            //                处理逻辑
            boolean flag = true;
            int[] tempArray = array.clone();
            for (int j = 0; j < len; j++) {
                int index = j % len;
                boolean goBack = false;
                int nextIndex = (index + 2) % len;
                if (index + 2 > len - 1) {
                    goBack = true;
                }
                if (goBack) {
                    if (tempArray[index] < tempArray[nextIndex]) {
                        int different = tempArray[index] - tempArray[nextIndex];
                        tempArray[index] -= different;
                        tempArray[nextIndex] += different;
                    }
                } else {
                    if (tempArray[index] > tempArray[nextIndex]) {
                        int different = tempArray[index] - tempArray[nextIndex];
                        tempArray[index] -= different;
                        tempArray[nextIndex] += different;
                    }
                }
            }
            for (int k = 0; k < len - 1; k++) {
                if (tempArray[i] > tempArray[i + 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
