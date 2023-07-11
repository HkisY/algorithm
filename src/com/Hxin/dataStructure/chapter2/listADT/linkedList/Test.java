package com.Hxin.dataStructure.chapter2.listADT.linkedList;

import java.util.Iterator;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/6
 */
public class Test {
    public static void main(String[] args) {
        //Test code which is written by myself
        LinkedListByMe<Integer> list = new LinkedListByMe<>();
        list.add(6);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2,12);
        list.add(1, 11);
        list.add(3, 13);
        list.remove(0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        final Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //Test code which is written by the book
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list2.add(6);
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(2,12);
        list2.add(1, 11);
        list2.add(3, 13);

        final Iterator<Integer> iterator2 = list2.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }

}
