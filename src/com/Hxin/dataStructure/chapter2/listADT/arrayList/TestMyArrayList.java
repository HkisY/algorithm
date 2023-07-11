package com.Hxin.dataStructure.chapter2.listADT.arrayList;

import java.util.Iterator;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/6
 */
public class TestMyArrayList {
    public static void main(String[] args) {
        ArrayListByMe<Integer> arrayList = new ArrayListByMe<>();
        arrayList.add(1);
        arrayList.add(9);
        arrayList.add(5);
        arrayList.add(4);
        arrayList.add(2);
        arrayList.add(8);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        System.out.println(arrayList.isEmpty());
        arrayList.clear();
        System.out.println( arrayList.isEmpty());

        arrayList.add(3);
        arrayList.add(6);
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(8);
        final Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
            iterator.remove();
        }
        System.out.println(arrayList.isEmpty());

        MyArrayList<String> myArrayList = new MyArrayList<>();
        final Iterator<String> iterator1 = myArrayList.iterator();

    }
}
