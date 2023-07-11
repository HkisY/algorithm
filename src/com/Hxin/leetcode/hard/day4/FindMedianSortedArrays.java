package com.Hxin.leetcode.hard.day4;

import java.util.Stack;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/7 20:56
 */

public class FindMedianSortedArrays {
    /**
     * 时间复杂度为O((m + n) / 2)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return double
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sumNum = len1 + len2;
        int num1Ite = 0, num2Ite = 0;
        Stack<Integer> res = new Stack<>();
        for (int i = 0; i < sumNum / 2 + 1; i++) {
            if (num1Ite < len1 && num2Ite < len2) {
                if (nums1[num1Ite] <= nums2[num2Ite]) {
                    res.push(nums1[num1Ite]);
                    num1Ite++;
                } else {
                    res.push(nums2[num2Ite]);
                    num2Ite++;
                }
            } else if (num1Ite >= len1) {
                res.push(nums2[num2Ite]);
                num2Ite++;
            } else {
                res.push(nums1[num1Ite]);
                num1Ite++;
            }
        }
        if (sumNum % 2 == 0) {
            return ((float) res.pop() + (float) res.pop()) / 2;
        } else {
            return (float) res.pop();
        }
    }

    /**
     * 二分法 满足时间复杂度
     * @param nums1 nums1
     * @param nums2 nums2
     * @return double
     */
    public static double findMedianSortedArraysWay(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}

