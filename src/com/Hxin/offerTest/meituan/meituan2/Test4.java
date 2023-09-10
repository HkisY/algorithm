package com.Hxin.offerTest.meituan.meituan2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/2 20:33
 */
public class Test4 {
    private static int res = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] array = new int[len];
        int deleteTime = sc.nextInt();
        int index = 0;
        for (int i = 0; i < len; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);

        int endTime = len - deleteTime;
        int[] flag = new int[len];
        dfs(0, flag, array, endTime);
        System.out.println(res);
    }

    private static void dfs(int count, int[] flag, int[] array, int endTime) {
        if (count == endTime) {
            if (judge(flag, array,endTime)) {
                res++;
                res = res % (1000000000 + 7);
            }
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (flag[i] == 0) {
                flag[i] = 1;
                dfs(count + 1, flag, array, endTime);
                flag[i] = 0;
            }
        }
    }

    private static boolean judge(int[] flag, int[] array, int endTime) {
        int temp = 0;
        int endLoop = 0;
        for (int i = 0; i < flag.length; i++) {
            if  (endLoop == endTime){
                break;
            }
            if (flag[i] == 1) {
                if (temp == 0) {
                    temp = array[i];
                    endLoop++;
                } else {
                    if (array[i] % temp == 0) {
                        temp = array[i];
                        endLoop++;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
