package com.Hxin.leetcode.simple.month1.day12;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：salary = [4000,3000,1000,2000]
 * 输出：2500.00000
 * 解释：最低工资和最高工资分别是 1000 和 4000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
 * <p>
 * 示例 2：
 * <p>
 * 输入：salary = [1000,2000,3000]
 * 输出：2000.00000
 * 解释：最低工资和最高工资分别是 1000 和 3000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000)/1= 2000
 * <p>
 * 示例 3：
 * <p>
 * 输入：salary = [6000,5000,4000,3000,2000,1000]
 * 输出：3500.00000
 * <p>
 * 示例 4：
 * <p>
 * 输入：salary = [8000,9000,2000,3000,6000,1000]
 * 输出：4750.00000
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/12 11:59
 */
public class Average {
    public static double average(int[] salary) {
        Arrays.sort(salary);
        double res = 0.000;
        for (int i = 1; i < salary.length - 1; i++) {
            res += salary[i];
        }
        return res / (salary.length - 2);
    }

    public static void main(String[] args) {
        int[] salary = {1000, 2000, 3000};
        DecimalFormat df = new DecimalFormat("0.00000");
        System.out.println(df.format(average(salary)));
    }
}
