package com.Hxin.dataStructure.chapter3.tree;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/13
 */
public class Test {

    public static void main(String[] args) {
        NormalTree<Integer> tree = new NormalTree<>();
        tree.insert(1);
        tree.insert(2, 1, NormalTree.CHILD);
        tree.insert(3, 2, NormalTree.SIBLING);
        tree.insert(4, 3, NormalTree.SIBLING);
        tree.insert(5, 4, NormalTree.CHILD);
        tree.insert(6, 4, NormalTree.SIBLING);
        tree.insert(7, 6, NormalTree.CHILD);
        tree.insert(8, 7, NormalTree.SIBLING);
        tree.insert(9, 8, NormalTree.CHILD);
        tree.insert(10, 9, NormalTree.SIBLING);
        tree.insert(11, 6, NormalTree.SIBLING);
        System.out.println(tree);
    }
}
