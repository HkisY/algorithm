package com.Hxin.dataStructure.chapter1.highEfficiencyPow;

/**
 * @author Hxin
 * @version 1.0
 * @see
 * @since 2022/4/5
 */
public class HighEfficiency {
    public static long pow(long x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return pow(x * x, n / 2);
        } else return pow(x * x, n / 2) * x;
    }

    public static long normalONPow(long x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * x;
        }
        return result;
    }

    public static void main(String[] args) {

        long startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
        System.out.println(pow(12,10));
        long endMili=System.currentTimeMillis();//结束时间
        System.out.println("结束--用时"+ (endMili-startMili));

        startMili=System.currentTimeMillis();// 当前时间对应的毫秒数
        System.out.println(normalONPow(12,10));
        endMili=System.currentTimeMillis();//结束时间
        System.out.println("结束--用时"+ (endMili-startMili));


    }
}
