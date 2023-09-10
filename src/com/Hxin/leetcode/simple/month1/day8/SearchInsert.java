package com.Hxin.leetcode.simple.month1.day8;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/8 21:45
 */
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        return searchInsertByBinary(nums, 0, nums.length - 1, target);
    }

    private static int searchInsertByBinary(int[] nums, int start, int end, int target) {
        int middle = (start + end) / 2;
        if (nums[middle] > target) {
            if (middle == 0) return 0;
            if (nums[middle - 1] < target) return middle;
            return searchInsertByBinary(nums, start, middle, target);
        } else if (nums[middle] < target) {
            if (middle == nums.length - 1) return nums.length;
            if (nums[middle + 1] > target) return middle + 1;
            return searchInsertByBinary(nums, middle + 1, end, target);
        } else {
            return middle;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }
}
