package com.Hxin.leetcode.simple.day4;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持
 * 一致 。然后返回 nums 中唯一元素的个数。考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums的其余元素与 nums 的大小不重要。
 * 返回 k。
 *
 * 判题标准:
 * 系统会用下面的代码来测试你的题解:
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 *
 * int k = removeDuplicates(nums); // 调用
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 *
 *
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2,_]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 *
 * 链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/6/6 20:29-21:09
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int temp = Integer.MIN_VALUE;
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0){
                res++;
                temp = nums[i];
                continue;
            }
            if (temp == nums[i]){
                temp = nums[i];
                nums[i] = Integer.MAX_VALUE;
            }else {
                res++;
                temp = nums[i];
            }
        }
        Arrays.sort(nums);

        return res;
    }

    public static int removeDuplicatesWay2(int[] nums) {
        int temp = Integer.MIN_VALUE;
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0){
                res++;
                temp = nums[i];
                continue;
            }
            if (temp == nums[i]){
                nums[i] = 0;
            }else {
                nums[res] = nums[i];
                res++;
                temp = nums[i];
            }
        }
        return res;
    }

    private static int removeDuplicatesWay(int[] nums){
        LinkedList<Integer> numsList = new LinkedList<>();
        for (int num:nums){
            numsList.add(num);
        }
        int tempNum = Integer.MIN_VALUE;
        for (int i = 0; i < numsList.size(); i++) {
            if (i == 0){
                tempNum = numsList.get(i);
                continue;
            }
            if (tempNum == numsList.get(i)){
                tempNum = numsList.get(i);
                numsList.remove(i);
            }else {
                tempNum = numsList.get(i);
            }
        }
        int[] result = new int[numsList.size()];
        for (int i = 0; i < numsList.size(); i++) {
            result[i] = numsList.get(i);
        }
        nums = result;

        return result.length;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,2,3,4};
        System.out.println(removeDuplicatesWay2(nums));
        for (int num : nums) {
            System.out.print(num + " ");

        }
    }
}
