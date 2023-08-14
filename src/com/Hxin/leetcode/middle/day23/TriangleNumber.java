package com.Hxin.leetcode.middle.day23;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/14 20:09
 */
public class TriangleNumber {
    public static void main(String[] args) {
        int[] nums = {19, 26, 26, 26, 80, 92, 77};
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        Map<Integer, Integer> mapNums = new HashMap<>();
        for (int num : nums) {
            if (mapNums.containsKey(num)) {
                int times = mapNums.get(num);
                mapNums.put(num, times + 1);
            } else {
                mapNums.put(num, 1);
            }
        }
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            Integer intI = mapNums.get(nums[i]);
            intI -= 1;
            mapNums.put(nums[i], intI);
            for (int j = i + 1; j < nums.length - 1; j++) {
                Integer intJ = mapNums.get(nums[j]);
                intJ -= 1;
                mapNums.put(nums[j], intJ);
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        Integer integer = mapNums.get(nums[k]);
                        res += integer;
                        k += integer - 1;
                        mapNums.put(nums[k], 0);
                    } else {
                        break;
                    }
                }
                intJ += 1;
                mapNums.put(nums[j], intJ);
            }
            intI -= 1;
            mapNums.put(nums[i], intI);
        }
        return res;
    }

    /**
     * TODO: 这思路真牛逼！
     * @param nums nums
     * @return int
     */
    public static int triangleNumberWay(int[] nums) {
        int[] map = new int[1001];
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            map[num]++;
            max = Math.max(max, num);
        }
        if (max == 0) return 0;
        int[] counts = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            counts[i] = counts[i - 1] + map[i];
        }
        int ans = 0;
        for (int i = 1; i <= max; i++) {
            int edge = map[i];
            // 等边三角形
            if (edge >= 3) {
                ans += edge * (edge - 1) * (edge - 2) / 6;
            }
            // 等腰三角形
            if (edge >= 2) {
                int target = i * 2 - 1;
                target = Math.min(target, max);
                ans += edge * (edge - 1) / 2 * (counts[target] - edge);
            }
            // 其它三角形
            if (edge > 0) {
                for (int j = i + 1; j <= max; j++) {
                    int edge2 = map[j];
                    if (edge2 > 0) {
                        int target = i + j - 1;
                        target = Math.min(target, max);
                        ans += edge * edge2 * (counts[target] - counts[j]);
                    }
                }
            }
        }
        return ans;
    }

    public static int binarySearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= target) {
                return i - 1;
            }
            if (i == a.length - 1) {
                return a.length - 1;
            }
        }
        return -1;
    }
}
