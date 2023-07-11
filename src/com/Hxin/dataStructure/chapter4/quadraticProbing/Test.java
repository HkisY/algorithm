package com.Hxin.dataStructure.chapter4.quadraticProbing;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/5/18
 */
public class Test {

    public static void main(String[] args) {
        QuadraticProbingHashTable<Integer> myHashTable = new QuadraticProbingHashTable<>();
        myHashTable.insert(89);
        myHashTable.insert(18);
        myHashTable.insert(49);
        myHashTable.insert(58);
        myHashTable.insert(69);
        myHashTable.insert(28);
    }
}
