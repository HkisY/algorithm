package com.Hxin.leetcode.middle.month1.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c],
 * nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * 链接：https://leetcode.cn/problems/4sum
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/29 20:00-20:25
 */
public class FourSum {
    /**
     * 在确定第一个数之后，如果nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target，说明此时剩下的三个数无论取什么值，四数之和一定大于
     * target,因此退出第一重循环；
     * 在确定第一个数之后，如果nums[i]+nums[n−3]+nums[n−2]+nums[n−1]<target，说明此时剩下的三个数无论取什么值，四数之和一定小于
     * target,因此第一重循环直接进入下一轮，枚举nums[i+1]；
     * 在确定前两个数之后，如果nums[i]+nums[j]+nums[j+1]+nums[j+2]>target，说明此时剩下的两个数无论取什么值，四数之和一定大于
     * target,因此退出第二重循环；
     * 在确定前两个数之后，如果nums[i]+nums[j]+nums[n−2]+nums[n−1]<target，说明此时剩下的两个数无论取什么值，四数之和一定小于
     * target，因此第二重循环直接进入下一轮，枚举nums[j+1]。
     *
     * @param nums int[]
     * @param target int
     * @return result
     */
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i]>target){
                break;
            }
            if (nums[nums.length-1]<target/4){
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int leftPoint = j + 1;
                int rightPoint = nums.length - 1;
                while (leftPoint < rightPoint) {
                    if (leftPoint > j + 1 && nums[leftPoint] == nums[leftPoint - 1]) {
                        leftPoint++;
                        continue;
                    }
                    if (rightPoint < nums.length - 1 && nums[rightPoint] == nums[rightPoint + 1]) {
                        rightPoint--;
                        continue;
                    }
                    long sum = (long)nums[i] + nums[j] + nums[leftPoint] + nums[rightPoint];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[leftPoint]);
                        list.add(nums[rightPoint]);
                        result.add(list);
                        leftPoint++;
                    } else if (sum > target) {
                        rightPoint--;
                    } else {
                        leftPoint++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        int target = -11;
        System.out.println(fourSum(nums, target));
    }
}
