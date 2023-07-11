package com.Hxin.dataStructure.chapter3.AVLTree;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/16
 */
public class TestAvlTree {
    public static void main(String[] args) {
        AvlTree<Integer> tree = new AvlTree<>();
        tree.insert(9);
        tree.insert(8);
        tree.insert(7);
        tree.insert(6);
        tree.insert(5);
        tree.printTree();
        System.out.println("\n");
        tree.insert(10);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.printTree();
        System.out.println("\n");
        tree.insert(3);
        tree.insert(4);
        tree.printTree();
        tree.insert(19);
        tree.insert(18);
        tree.printTree();
        System.out.println("\n");
    }
}
