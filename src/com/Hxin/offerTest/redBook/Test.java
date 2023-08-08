package com.Hxin.offerTest.redBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/8/6 19:22
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        ArrayList<String> res = solution(s);
        for (String re : res) {
            System.out.println(re);
        }

    }

    private static ArrayList<String> solution(String[] strings) {
        Map<String, Integer> temp = new HashMap<>();
        for (String string : strings) {
            if (temp.containsKey(string)) {
                Integer integer = temp.get(string);
                temp.put(string, integer + 1);
            } else {
                temp.put(string, 1);
            }
        }

        String[] stringRes = new String[strings.length];
        int[] intRes = new int[strings.length];
        int index = 0;

        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            if (entry.getValue() >= 3) {
                stringRes[index] = entry.getKey();
                intRes[index] = entry.getValue();
                index++;
            }
        }
        ArrayList<ArrayList<String>> stringArrayList = new ArrayList<>();
        for (int i = strings.length; i >= 0; i--) {
            ArrayList<String> tempList = new ArrayList<>();
            for (int j = 0; j < intRes.length; j++) {
                if (intRes[j] == i) {
                    if (stringRes[j] != null) {
                        tempList.add(stringRes[j]);
                    }
                }
            }
            stringArrayList.add(tempList);
        }
        ArrayList<String> result = new ArrayList<>();
        for (ArrayList<String> arrayList : stringArrayList) {
            if (arrayList.size() == 1) {
                result.add(arrayList.get(0));
            } else if (arrayList.size() > 1) {
                ArrayList<String> l = sortedByDic(arrayList);
                result.addAll(l);
            }
        }

        return result;
    }

    private static ArrayList<String> sortedByDic(ArrayList<String> arrayList) {
        ArrayList<String> res = new ArrayList<>();
        byte[][] compare = new byte[arrayList.size()][16];
        int index = 0;
        for (String s : arrayList) {
            compare[index++] = s.getBytes();
        }
        int cIndex = 0;
        int num = Integer.MAX_VALUE;
        int resIndex = 0;
        int loopIndex = 0;
        boolean nextWord = false;
        String finalString = null;
        int loopTime = 0,loopEnds = compare.length;
        while (true) {
            for (int j = 0; j < compare.length; j++) {
                int a = compare[j][loopIndex] - 'a';
                if (num > a) {
                    loopTime =1;
                    resIndex = j;
                    finalString = new String(compare[j]);
                    num = a;
                    nextWord = false;
                }
                if (num == a){
                    loopTime++;
                }
            }
            if (loopTime == loopEnds){
                nextWord = true;
            }
            compare[resIndex][loopIndex] = 123;
            if (nextWord) {
                res.add(finalString);
                num = Integer.MAX_VALUE;
                cIndex++;
                if (cIndex >= compare.length) {
                    break;
                }
            }else {
                loopIndex++;
            }
            finalString = null;
        }
        return res;
    }
}
