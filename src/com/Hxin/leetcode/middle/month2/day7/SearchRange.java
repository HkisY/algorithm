package com.Hxin.leetcode.middle.month2.day7;

/**
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/10  16:10
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] res = searchRange(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int n = nums.length;
        if (n == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        if (n == 1) {
            res[0] = nums[0] == target ? 0 : -1;
            res[1] = nums[0] == target ? 0 : -1;
            return res;
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                //二分查相同元素
                res = findTheRange(nums, middle, target);
                return res;
            } else if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle;
            }
        }

        res[0] = -1;
        res[1] = -1;
        return res;
    }

    private static int[] findTheRange(int[] nums, int middle, int target) {
        int[] res = new int[2];
        for (int i = middle; i < nums.length; i++) {
            if (nums[i] == target) {
                res[1] = i;
            } else {
                break;
            }
        }
        for (int i = middle; i >= 0; i--) {
            if (nums[i] == target) {
                res[0] = i;
            } else {
                break;
            }
        }
        return res;
    }
}
