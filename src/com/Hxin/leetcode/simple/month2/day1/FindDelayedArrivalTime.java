package com.Hxin.leetcode.simple.month2.day1;

/**
 * 2651
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/8  15:15
 */
public class FindDelayedArrivalTime {
    public static void main(String[] args) {

    }
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return  (arrivalTime+delayedTime)%24;
    }
}
