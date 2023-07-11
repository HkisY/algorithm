package com.Hxin.dataStructure.chapter2.practice.exam1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/7
 */
public class Exam {
    /**
     * 接口方法
     * L P 均为排序好的
     */

    public static <T> void printLots(List<T> L, List<Integer> P) {
        Iterator<T> iterL = L.iterator();
        Iterator<Integer> iterP = P.iterator();

        T itemL = null;
        Integer itemP = 0;
        int start = 0;

        while (iterL.hasNext() && iterP.hasNext()) {
            itemP = iterP.next();

            System.out.println("Looking for position " + itemP);
            while (start < itemP && iterL.hasNext()) {
                start++;
                itemL = iterL.next();
            }
            System.out.println(itemL);
        }
    }

    //未排序
    public static void printLotsByMe(List<Integer> index, List<Integer> target) {
        index.sort(Integer::compareTo); //lambda
        int indexNum = index.get(index.size() - 1);
        int targetNum = target.size();
        if (indexNum > targetNum) {
            throw new IndexOutOfBoundsException();
        }
        for (Integer integer : index) {
            System.out.print(target.get(integer) + " ");
        }

    }


    public static void main(String[] args) {
        ArrayList<Integer> index = new ArrayList<>();
        index.add(1);
        index.add(3);
        index.add(4);
        index.add(6);
        index.add(10);
        index.add(2);

        ArrayList<Integer> target = new ArrayList<>();
        target.add(1);
        target.add(2);
        target.add(3);
        target.add(12);
        target.add(13);
        target.add(23);
        target.add(123);
        target.add(1234);
        target.add(1235);
        target.add(1236);
        target.add(1237);
        target.add(1238);

        printLotsByMe(index, target);
//        printLots(target, index);

    }
}
