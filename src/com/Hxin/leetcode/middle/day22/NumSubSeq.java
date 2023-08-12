package com.Hxin.leetcode.middle.day22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 * 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。
 * 由于答案可能很大，请将结果对 109 + 7 取余后返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,5,6,7], target = 9
 * 输出：4
 * 解释：有 4 个子序列满足该条件。
 * [3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,3,6,8], target = 10
 * 输出：6
 * 解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [2,3,3,4,6,7], target = 12
 * 输出：61
 * 解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
 * 有效序列总数为（63 - 2 = 61）
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/11 19:21
 */
public class NumSubSeq {
    static final int P = 1000000007;
    static final int MAX_N = 100005;
    static int[] f = new int[MAX_N];

    public static void main(String[] args) {
        int[] nums = {3, 5, 6, 7};
//        int[] nums = {2,3,3,4,6,7};
        int target = 9;
        System.out.println(numSubSeqWay(nums, target));
    }

    /**
     * wrong answer
     *
     * @param nums   nums
     * @param target target
     * @return int
     */
    public static int numSubSeqByDp(int[] nums, int target) {
        int arrayLength = nums.length;
        int[][] dp = new int[arrayLength][arrayLength];
        List<Integer>[] arrayLists = new ArrayList[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            arrayLists[i] = new ArrayList<>();
            arrayLists[i].add(i);
            if (nums[i] <= target) {
                dp[0][i] = 1;
            }
        }
        //minAndMax[0]存储min minAndMax[1]存储max
        long[][] minAndMax = new long[2][arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            minAndMax[0][i] = nums[i];//min
            minAndMax[1][i] = nums[i];//max
        }
//        for (int i = 1; i < arrayLength; i++) {
//            for (int j = 0; j < arrayLength; j++) {
//                if (arrayLists[i].contains(j)) {
//                    dp[i][j] = dp[i - 1][j];
//                    continue;
//                }
//                if (nums[j] <= minAndMax[1][i] || nums[j] >= minAndMax[0][i]) {
//                    arrayLists[i].add(j);
//                    dp[i][j] = dp[i - 1][j] + i * (i + 1) / 2;
//                } else if (nums[j] > minAndMax[1][i] && nums[j] - minAndMax[0][i] <= target) {
//                    arrayLists[i].add(j);
//                    dp[i][j] = dp[i - 1][j] + i * (i + 1) / 2;
//                    minAndMax[1][i] = nums[j];
//                } else if (nums[j] < minAndMax[0][i] && minAndMax[1][i] - nums[j] <= target) {
//                    arrayLists[i].add(j);
//                    dp[i][j] = dp[i - 1][j] + i * (i + 1) / 2;
//                    minAndMax[0][i] = nums[j];
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//            }
//        }
        long res = 0L;
        for (int i = 0; i < arrayLength; i++) {
            System.out.println(dp[arrayLength - 1][i]);
            res += dp[arrayLength - 1][i];
        }
        //减去重复计算
        return (int) (res % (1000000000 + 7));
    }

    public static int numSubSeq(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0, end = 0;
        int length = nums.length;
        List<Integer> suitableBlockLength = new ArrayList<>();
        while (start < length) {
            if (end == length - 1) {
                suitableBlockLength.add(end - start);
                break;
            }
            if (nums[end] + nums[start] <= target) {
                end++;
            } else {
                suitableBlockLength.add(end - start);
                start = end;
            }
        }
        long res = 0L;
        for (Integer num : suitableBlockLength) {
            res += (long) num * (num + 1) / 2;
        }
        return (int) (res % (1000000000 + 7));
    }

    public static int numSubSeqWay(int[] nums, int target) {
        pretreatment();
        Arrays.sort(nums);

        int ans = 0;
        for (int i = 0; i < nums.length && nums[i] * 2 <= target; ++i) {
            int maxValue = target - nums[i];
            int pos = binarySearch(nums, maxValue) - 1;
            int contribute = (pos >= i) ? f[pos - i] : 0;
            ans = (ans + contribute) % P;
        }

        return ans;
    }

    public static void pretreatment() {
        f[0] = 1;
        for (int i = 1; i < MAX_N; ++i) {
            f[i] = (f[i - 1] << 1) % P;
        }
    }

    public static int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (mid == nums.length) {
                return mid;
            }
            int num = nums[mid];
            if (num <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
