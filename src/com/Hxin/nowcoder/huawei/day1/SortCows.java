package com.Hxin.nowcoder.huawei.day1;

/**
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/20  17:41
 */
public class SortCows {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 4, 2, 7, 6};
        sortCowsByQuickSort(nums, 0, nums.length - 1);
    }

    public static int[] sortCows(int[] nums) {
        // write code here
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tempNum = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tempNum;
                }
            }
        }
        return nums;
    }

    public static void sortCowsByQuickSort(int[] nums, int start, int end) {
        int leftPoint = start, rightPoint = end;
        if (start > end || start == end) {
            return;
        }
        while (leftPoint != rightPoint) {
            if (leftPoint < rightPoint) {
                if (nums[leftPoint] > nums[rightPoint]) {
                    int tempNum = nums[leftPoint];
                    nums[leftPoint] = nums[rightPoint];
                    nums[rightPoint] = tempNum;
                    tempNum = leftPoint;
                    leftPoint = rightPoint;
                    rightPoint = tempNum;
                    rightPoint++;
                } else {
                    rightPoint--;
                }
            } else {
                if (nums[rightPoint] > nums[leftPoint]) {
                    int tempNum = nums[leftPoint];
                    nums[leftPoint] = nums[rightPoint];
                    nums[rightPoint] = tempNum;
                    tempNum = leftPoint;
                    leftPoint = rightPoint;
                    rightPoint = tempNum;
                    rightPoint--;
                } else {
                    rightPoint++;
                }
            }

        }
        sortCowsByQuickSort(nums, start, leftPoint);
        sortCowsByQuickSort(nums, leftPoint + 1, end);
    }
}
