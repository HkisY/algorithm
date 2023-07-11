package com.Hxin.dataStructure.chapter3.binaryTree;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/13
 */
public class TestSearchTree {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

//        tree.insert(3);
//        tree.insert(4);
//        tree.insert(5);
//        //sorted
//        tree.printTree();
//        tree.remove(4);
//        tree.printTree();
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.remove(5);

    }
}
