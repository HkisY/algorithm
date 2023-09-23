package com.Hxin.offerTest.wangyi;

/**
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/23  17:49
 */
public class Test4 {
    public static double subsequenceAverageSum(int[] nums) {
        int n = nums.length;
        double sum = 0;

        // Total number of non-empty subsequences: 2^n - 1
        int totalSubsequences = (1 << n) - 1;

        // For each subsequence
        for (int i = 1; i <= totalSubsequences; i++) {
            double subsequenceSum = 0;
            int subsequenceLength = 0;

            // Calculate the sum and length of the current subsequence
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subsequenceSum += nums[j];
                    subsequenceLength++;
                }
            }

            // Add the average of the current subsequence to the total sum
            sum += subsequenceSum / subsequenceLength;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        double result = subsequenceAverageSum(nums);
        System.out.println("The sum of averages of all subsequences is: " + result);
    }
}
