package com.Hxin.offerTest.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/10 21:21
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = in.nextInt();
        }
        Arrays.sort(array);
        int start = 0, end = length - 1;
        int ans = 0;
        int battlePoint = 0;
        while (start <= end) {
            if (array[end]>=battlePoint){
                ans+=array[end]-battlePoint;
            }
            battlePoint = array[end];
            end--;
            if (array[start] >= battlePoint) {
                ans += array[start] - battlePoint;
            }
            battlePoint=array[start];
            start++;
        }
        System.out.println(ans);
    }
}
