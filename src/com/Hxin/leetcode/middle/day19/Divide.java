package com.Hxin.leetcode.middle.day19;

/**
 * 给你两个整数，被除数dividend和除数divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 * 返回被除数dividend除以除数divisor得到的 商 。
 * <p>
 * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2^31, 2^31− 1] 。本题中，如果商 严格大于 2^31− 1 ，则返回 2^31− 1 ；如果商
 * 严格小于 -2^31 ，则返回 -2^31 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/7/9 21:22
 */
public class Divide {
    public static int divide(int dividend, int divisor) {
        final int minValue = Integer.MIN_VALUE;
        final int maxValue = Integer.MAX_VALUE;
        //仅有一种情况溢出
        if (dividend == minValue && divisor == -1) {
            return maxValue;
        }
        //标记结果的正负 true 为 负
        boolean flag = (((dividend >>> 31) ^ (divisor >>> 31)) == 1);
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        int result = 0;
        while (dividend < 0) {
            dividend -= divisor;
            if (dividend > 0) break;
            result++;
        }
        if (flag) {
            return -result;
        }
        return result;
    }


    public static int divideWay(int dividend, int divisor) {
        final int minValue = Integer.MIN_VALUE;
        final int maxValue = Integer.MAX_VALUE;
        //仅有一种情况溢出
        if (dividend == minValue && divisor == -1) {
            return maxValue;
        }
        //标记结果的正负 true 为 负
        boolean flag = (((dividend >>> 31) ^ (divisor >>> 31)) == 1);
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;

        int canDivisor = divisor;
        int middleValue = dividend >> 1;
        int tempRes = -1;
        while (canDivisor >= middleValue) {
            canDivisor <<= 1;
            tempRes <<= 1;
        }
        int result = 0;
        while (dividend <= divisor) {
            while (canDivisor < dividend) {
                canDivisor >>= 1;
                tempRes >>= 1;
            }
            while (dividend <= canDivisor) {
                dividend -= canDivisor;
                result -= tempRes;
            }
        }


        if (flag) {
            return -result;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = -11;
        int b = 2;
        System.out.println(divide(a, b));
    }
}
