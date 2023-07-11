package com.Hxin.leetcode.middle.day11;

/**
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 * <p>
 * 链接：https://leetcode.cn/problems/container-with-most-water
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/25 21:24-22:00
 */
public class MaxArea {
    //Time out
    public static int maxArea(int[] height) {
        int areaLength;
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int basisHeight = height[i];
                areaLength = j - i;
                if (height[j] < basisHeight) {
                    basisHeight = height[j];
                }

                int tempArea = areaLength * basisHeight;
                result = Math.max(result, tempArea);
            }
        }
        return result;
    }


    public static int maxAreaWay(int[] height) {
        int leftIndex = 0, rightIndex = height.length - 1;
        int result = 0;
        while (leftIndex < rightIndex) {
            int poolLength = rightIndex - leftIndex;
            if (height[leftIndex] < height[rightIndex]) {
                result = Math.max(poolLength * height[leftIndex], result);
                leftIndex++;
            } else {
                result = Math.max(poolLength * height[rightIndex], result);
                rightIndex--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 1, 4};
        System.out.println(maxAreaWay(a));
    }
}
