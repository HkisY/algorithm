package com.Hxin.leetcode.middle.month2.day5;


import java.util.Arrays;

/**
 * 31
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/8  15:45
 */
public class NextPermutation {
    public static void main(String[] args) {
//        int[] nums = {1, 3, 2};
        int[] nums = {5,4,1,2,3};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                max = Math.max(max, nums[i]);
                break;
            }
            if (nums[i + 1] > nums[i]) {
                max = nums[i + 1];
            }
        }
        if (nums[nums.length - 1] + 1 > max) {
            //交换末尾两个数字
            swapEle(nums, nums.length - 1, nums.length - 2);
        } else {
            int tempIndex = nums.length - 1;
            //逆序
            while (nums[tempIndex] + 1 == nums[tempIndex - 1]) {
                if (tempIndex == 1 ) {
                    if (nums[tempIndex] + 1 == nums[tempIndex - 1]){
                        tempIndex = -1;
                    }
                    break;
                }
                tempIndex--;
            }
            if (tempIndex == -1) {
                Arrays.sort(nums);
                return;
            }
            //升序
            if (tempIndex == nums.length-1){
                while (nums[tempIndex]<nums[tempIndex - 1]){
                    tempIndex--;
                }
                swapEle(nums,tempIndex,tempIndex-1);
                Arrays.sort(nums, tempIndex, nums.length);
                return;
            }
            swapEle(nums, tempIndex - 1, nums.length - 1);
            Arrays.sort(nums, tempIndex, nums.length);
        }
    }

    private static void swapEle(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
