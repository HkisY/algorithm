package com.Hxin.dataStructure.chapter3.practice.exam16;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/18
 */
public class Test {

    public static void main(String[] args) {
        TreeSetLazyDelete<Integer> set = new TreeSetLazyDelete<>();
        set.insert(5);
        set.insert(1);
        set.insert(2);
        set.insert(3);
        set.insert(4);
        set.insert(10);
        set.insert(9);
        set.insert(7);
        set.insert(11);
        set.insert(12);

        set.remove(10);
        set.remove(12);
//        set.remove(9);
        set.remove(7);
        set.remove(11);
//        System.out.println( set.findMaxWithoutFlag());
//        System.out.println( set.findMinWithoutFlag());
        System.out.println(set.findMax());
    }
}
