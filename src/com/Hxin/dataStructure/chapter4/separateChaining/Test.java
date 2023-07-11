package com.Hxin.dataStructure.chapter4.separateChaining;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/5/18
 */
public class Test {
    public static void main(String[] args) {
        SeparateChainingHashTable<Integer> sc = new SeparateChainingHashTable<>();
        sc.insert(10);
        sc.insert(20);
        sc.insert(30);
        sc.insert(40);
    }
}
