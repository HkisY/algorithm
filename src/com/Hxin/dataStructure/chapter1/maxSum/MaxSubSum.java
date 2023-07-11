package com.Hxin.dataStructure.chapter1.maxSum;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/5
 */
public class MaxSubSum {
    //分治法求最大子序列和
    public static int maxSubSum(int[] a, int left, int right) {
        if (left == right) {
            return Math.max(a[left], 0);
        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSubSum(a, 0, center);
        int maxRightSum = maxSubSum(a, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += a[i];
            if (leftBorderSum > maxLeftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i < right; i++) {
            rightBorderSum += a[i];
            if (rightBorderSum > maxRightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }
        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum + maxRightBorderSum);
    }

    public static int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }


    public static void main(String[] args) {
        int[] a = {2,4,6,8,-1,4,-6,-7,4,5,-3};
        int b = maxSubSum(a,0,a.length-1);
        System.out.println(b);
    }
}
