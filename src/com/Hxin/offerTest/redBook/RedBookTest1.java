package com.Hxin.offerTest.redBook;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/8/6 13:56
 */
public class RedBookTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
        for (String value : list) {
            final String[] s = value.split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            double sum = sum(n, m);
            System.out.println(new DecimalFormat("0.00").format( sum));
        }
    }


    private static double sum(int n, int m){
        double sum = 0;
        double temp = n;
        for (int i = 0; i < m; i++) {
            sum += temp;
            temp = Math.sqrt(temp);
        }
        return sum;
    }
}
