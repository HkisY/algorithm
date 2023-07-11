package com.Hxin.leetcode.middle.day12;


import java.util.*;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * gb
 * 链接：https://leetcode.cn/problems/3sum
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/27 20:49
 */
public class ThreeSum {
    //Time out
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Set<Integer>> judge = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        Set<Integer> tempSet = new HashSet<>();
                        int max = Math.max(Math.max(nums[i], nums[j]), nums[k]);
                        int min = Math.min(Math.min(nums[i], nums[j]), nums[k]);
                        int middle = nums[i] + nums[j] + nums[k] - max - min;
                        tempSet.add(max);
                        tempSet.add(min);
                        tempSet.add(middle);

                        if (judge.isEmpty()) {
                            judge.add(tempSet);
                            result.add(tempList);
                        }
                        if (!judge.contains(tempSet)) {
                            judge.add(tempSet);
                            result.add(tempList);
                        }
                    }
                }
            }
        }
        return result;
    }

    private static List<List<Integer>> threeSumWay(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int leftNum = nums[i];
            int rightPoint = nums.length - 1;
            for (int leftPoint = i + 1; leftPoint < nums.length; leftPoint++) {
                if (leftPoint > i + 1 && nums[leftPoint] == nums[leftPoint - 1]) {
                    continue;
                }
                while (leftPoint < rightPoint && nums[leftPoint] + nums[rightPoint] > -nums[i]) {
                    rightPoint--;
                }
                if (leftPoint == rightPoint) {
                    break;
                }
                if (nums[leftPoint] + nums[rightPoint] + nums[i] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(leftNum);
                    list.add(nums[leftPoint]);
                    list.add(nums[rightPoint]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        Arrays.sort(nums);
        System.out.println(threeSumWay(nums));
    }
}
