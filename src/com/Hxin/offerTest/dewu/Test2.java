package com.Hxin.offerTest.dewu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/12 11:51
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int k = sc.nextInt();
        int[] arrays = new int[length];
        for (int i = 0; i < length; i++) {
            arrays[i] = sc.nextInt();
        }
        Arrays.sort(arrays);
        int nums = 0, ans = 0;
        int flag = -1;
        for (int i = 0; i < length; i++) {
            if (arrays[i] >= 0) {
                nums++;
                ans += arrays[i];
            }
        }
        for (int i = 0; i < length; i++) {
            if (arrays[i] >= 0) {
                flag = i;
                break;
            }
        }
        boolean flagTag = false;
        if (nums % 3 != 0) {
            boolean legal = true;
            int n = nums % 3;
            int a1 = 0;
            for (int i = 0; i < n; i++) {
                a1 += arrays[flag + i];
            }
            int b = 3 - n + 1;
            int a2 = 0;
            for (int i = 1; i < b && i < arrays.length; i++) {
                if (flag-i<=0){
                    legal =false;
                    break;
                }
                a2 += arrays[flag - i];
            }
            if (legal){
                if (a1 + a2 >= 0 && k > a1 + a2) {
                    ans += a2;
                    nums += 3 - n;
                    flagTag = true;
                }
            }
        }


        int tempSum = 0;
        int tempNum = 0;
        int tempAns = 0;
        if (flagTag) {
            for (int i = flag - 1 - (3 - nums % 3); i >= 0; i--) {
                tempSum += arrays[i];
                tempNum++;
//            满足3个，每3个检验一次
                if (tempNum % 3 == 0) {
                    if (tempSum > -k) {
                        nums += 3;
                        ans += tempSum;
                    }
                    tempNum = 0;
                    tempSum = 0;
                }
//            不满足3个

            }
        } else {
            for (int i = flag - 1; i >= 0; i--) {
                tempSum += arrays[i];
                tempNum++;
//            满足3个，每3个检验一次
                if (tempNum % 3 == 0) {
                    if (tempSum > -k) {
                        nums += 3;
                        ans += tempSum;
                    }
                    tempNum = 0;
                    tempSum = 0;
                }
//            不满足3个

            }
        }
        int numsValue = nums / 3 * k;
        System.out.println(numsValue + ans + tempAns);
    }
}
