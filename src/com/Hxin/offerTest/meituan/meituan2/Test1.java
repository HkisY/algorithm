package com.Hxin.offerTest.meituan.meituan2;

import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/2 13:54
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] array = new int[len];
        int index = 0;
        while (sc.hasNextInt()) {
            array[index] = sc.nextInt();
            index++;
        }
        int tempA = Integer.MIN_VALUE;
        int tempB = Integer.MIN_VALUE;
        boolean res = true;
//        int len = 3;
//        int[] array = {1, 3, 4};
        for (int i = 0; i < len; i++) {
            if (i == 0){
                tempA = array[i];
                tempB = array[1]-array[0];
                continue;
            }
            if (array[i] - tempA > 0) {
                tempA = array[i];
            } else {
                res = false;
            }
            if (i < len - 1) {
                int dis = array[i + 1] - array[i];
                if (dis <tempB) {
                    tempB = dis;
                } else {
                    res = false;
                }
            }

        }

        System.out.println(res ? "Yes" : "No");
    }
}
