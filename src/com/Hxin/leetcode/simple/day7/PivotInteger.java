package com.Hxin.leetcode.simple.day7;

/**
 * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
 * 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
 * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。
 * <p>
 * 示例 1：
 * 输入：n = 8
 * 输出：6
 * 解释：6 是中枢整数，因为 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21 。
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 解释：1 是中枢整数，因为 1 = 1 。
 * <p>
 * 示例 3：
 * 输入：n = 4
 * 输出：-1
 * 解释：可以证明不存在满足题目要求的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-pivot-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/6/26 22:48
 */
public class PivotInteger {
    public static int pivotInteger(int n) {
        int start = 1;
        int end = n;
        int preSum = 1, fixSum = n;
        while (start < end) {
            if (preSum < fixSum) {
                start++;
                preSum += start;
            } else if (preSum > fixSum) {
                end--;
                fixSum += end;
            } else {
                start++;
                end--;
                preSum += start;
                fixSum += end;
            }
        }

        return preSum == fixSum ? start : -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotInteger(4));
    }
}
