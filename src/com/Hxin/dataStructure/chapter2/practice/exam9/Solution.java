package com.Hxin.dataStructure.chapter2.practice.exam9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/8
 */
public class Solution<T> {
    ArrayList<T> arrayList = new ArrayList<>();
    //exam9
    public void arrAddAll(Iterable<? extends T> items){
        final Iterator<? extends T> iterator = items.iterator();
        while (iterator.hasNext()){
            arrayList.add(iterator.next());
        }
    }

    LinkedList<T> linkedList = new LinkedList<>();
    public void linkRemoveAll(Iterable<? extends T> items){
        for (T item : items) {
            linkedList.remove(item);
        }
    }

    public static void main(String[] args) {
        Solution<Integer> solution = new Solution<>();
        solution.arrayList.add(1);
        solution.arrayList.add(2);
        solution.arrayList.add(14);
        ArrayList<Integer> targetArray = new ArrayList<>();
        targetArray.add(3);
        targetArray.add(6);
        targetArray.add(7);
        solution.arrAddAll(targetArray);
        for (Integer i: solution.arrayList){
            System.out.print(i+" ");
        }

        System.out.print("\n");
        solution.linkedList.add(1);
        solution.linkedList.add(3);
        solution.linkedList.add(6);
        LinkedList<Integer> targetLink = new LinkedList<>();
        targetLink.add(3);
        targetLink.add(6);
        targetLink.add(7);
        solution.linkRemoveAll(targetLink);
        for (Integer i: solution.linkedList){
            System.out.print(i+" ");
        }


    }

}
