package com.Hxin.offerTest.meituan;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/8/26 11:09
 */
public class Test5 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int len = sc.nextInt();
//        int target = sc.nextInt();
//        int[] array = new int[len];
//        for (int i = 0; i < len; i++) {
//            array[i] = sc.nextInt();
//        }
        int[] array = {1, 3, 2, 4, 1};
        int target = 2;
        int res = findTheNum(array, target);
        System.out.println(res);
    }

    private static int findTheNum(int[] array, int target) {
        int res = 0;
        int[] flagPre = new int[array.length];
        int[] preSum = new int[array.length];
        System.arraycopy(array, 0, preSum, 0, array.length);
        //前缀和
        int board = 1;
        while (board < array.length) {
            for (int i = 0; i < flagPre.length - board; i++) {
                preSum[i] += array[i + board];
                if (preSum[i] > target * (board + 1)) {
                    continue;
                }
                flagPre[i] += 1;
            }
            board++;
        }

        for (int i : flagPre) {
            if (i > 0) {
                res = Math.max(i, res);
            }
        }
        return res == 0 ? -1 : res + 1;
    }
}
