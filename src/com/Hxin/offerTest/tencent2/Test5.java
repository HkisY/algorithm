package com.Hxin.offerTest.tencent2;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/15 21:09
 */
public class Test5 {
    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("/Users/hkisy/Documents/Algorithm/src/com/Hxin/offerTest");
        for (String s : f.list()) {
            final String[] split = s.split(".");
            System.out.println(s);
        }
    }

    public static int solution(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        int middle = (start + end) / 2;
        while (start != end) {
            middle = (start + end) / 2;
            if (a[middle] > target) {
                end = middle;
            } else if (a[middle] < target) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return middle;
    }
}
