package com.Hxin.offerTest.meituan.meituan2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/2 19:53
 */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] array = new int[len];
        int index = 0;
        while (in.hasNextInt()) {
            array[index] = in.nextInt();
            index++;
        }

        int target = array[0];
        int ans = 0;
        int[] newArray = new int[len - 1];
        System.arraycopy(array, 1, newArray, 0, len - 1);
        Arrays.sort(newArray);
        for (int i = 0; i < len - 1; i++) {
            if (newArray[i] > target) {
                if (newArray[i] - target == 1) {
                    newArray[i] = newArray[i] / 2;
                } else {
                    target = target * 2;
                }
                i = i - 1;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
