package com.Hxin.offerTest.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/10 20:48
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int loop = in.nextInt();
        for (int i = 0; i < loop; i++) {
            int length = in.nextInt();
            int[] source = new int[length];
            for (int j = 0; j < length; j++) {
                source[j] = in.nextInt();
            }
            int[] target = new int[length - 1];
            for (int j = 0; j < length - 1; j++) {
                target[j] = in.nextInt();
            }
//            处理逻辑
            int[] tempArray = new int[length];
            System.arraycopy(source, 0, tempArray, 0, length);
            Arrays.sort(tempArray);
//            寻找中位数函数
            findTheMiddleNum(tempArray, 0);
            for (int j = 0; j < target.length; j++) {
                source[target[j] - 1] = -1;
                System.arraycopy(source, 0, tempArray, 0, length);
                Arrays.sort(tempArray);
                findTheMiddleNum(tempArray, j + 1);
            }
            System.out.println();
        }
        in.close();
    }

    private static void findTheMiddleNum(int[] source, int spend) {
        int[] arr = new int[source.length - spend];
        if (source.length - spend >= 0) System.arraycopy(source, spend, arr, 0, source.length - spend);
        if (arr.length % 2 == 1) {
            System.out.print(arr[arr.length / 2] + " ");
        } else {
            int middle = arr.length / 2;
            if ((arr[middle - 1] + arr[middle]) % 2 == 1) {
                System.out.print((arr[middle - 1] + (float) arr[middle]) / 2 + " ");
            } else {
                System.out.print((arr[middle - 1] + arr[middle]) / 2 + " ");
            }
        }
    }

}
