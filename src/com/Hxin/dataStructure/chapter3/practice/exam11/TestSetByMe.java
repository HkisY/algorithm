package com.Hxin.dataStructure.chapter3.practice.exam11;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/17
 */
public class TestSetByMe {
    public static void main(String[] args) {
        TreeSetByMe<Integer> set = new TreeSetByMe<>();
//        System.out.println();
//        set.add(4);
//        set.add(6);
//        set.add(7);
//        set.add(1);
//        set.add(2);
//        set.add(9);
//        System.out.println(set.add(10));
//        System.out.println(set.add(6));
//        Test1 the TreeSetByMe`s method
//        set.add(6);
//        set.add(4);
//        set.add(5);
//        set.add(2);
//        set.add(1);
//        set.add(3);
//        set.add(11);
//        Iterator<Integer> iterator = set.iterator();
//        while (iterator.hasNext()){
//            int temp = iterator.next();
//            if (temp == 2){
//                iterator.remove();
//            }
//            System.out.println(temp);
//        }
//        Iterator<Integer> iterator2 = set.iterator();
//        while (iterator2.hasNext()){
//            System.out.println(iterator2.next());
//        }
//        set.remove(5);
//        set.remove(7);
//        System.out.println( set.contains(4));
//        System.out.println( set.contains(7));
//        set.containNode(7);
//         set.containNode(6);
        //Test1 the MyTreeSet`s remove method
        MyTreeSet<Integer> myTreeSet = new MyTreeSet<>();
        myTreeSet.insert(6);
        myTreeSet.insert(4);
        myTreeSet.insert(5);
        myTreeSet.insert(1);
        myTreeSet.insert(2);
        myTreeSet.insert(11);
//        myTreeSet.remove(5);
        final Iterator<Integer> iterator = myTreeSet.iterator();
        while (iterator.hasNext()){
            iterator.remove();
            System.out.println(iterator.next());
        }

    }
}
