package com.Hxin.dataStructure.chapter3.tree;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * TODO: 待完工
 * @author Hxin
 * @version 1.0
 * @since 2022/4/13
 */
public class NormalTree<T> {
    public final static String CHILD = "child";
    public final static String SIBLING = "sibling";
    private TreeNode<T> root;
    private int num = 0;


    NormalTree() {
        doClear();
    }

    public void makeEmpty() {
        doClear();
    }

    public boolean isEmpty() {
        return root.data == null;
    }

    private void doClear() {
        this.root = new TreeNode<>(null, null, null);
    }

    public int size() {
        return num;
    }

    /*
    根节点插入
     */
    public void insert(T t) {
        num++;
        root = new TreeNode<>(t, null, null);
    }

    public void insert(T t, T targetEle, String position) {
        num++;
        TreeNode<T> node = findNode(targetEle);
        insert(t, node, position);
    }

    private void insert(T t, TreeNode<T> node, String position) {
        if (isEmpty()) {
            root = new TreeNode<>(t, null, null);
            return;
        }
        if (position.equals(CHILD)) {
            if (node.firstChild != null) {
                node = node.firstChild;
                insert(t, node, SIBLING);
            } else {
                node.firstChild = new TreeNode<>(t, null, null);
            }
        } else if (position.equals(SIBLING)) {
            while (node.nextSibling != null) {
                node = node.nextSibling;
            }
            node.nextSibling = new TreeNode<>(t, null, null);
        }

    }

    private TreeNode<T> findNode(T t) {
        return findNode(t, this.root);
    }

    /*
    根据T data来寻找节点
     */
    private TreeNode<T> findNode(T t, TreeNode<T> node) {
        if (isEmpty()) return null;

        if (node.data.equals(t)) {
            return node;
        }
        //有子节点，递归子节点
        if (node.firstChild != null) {
            return findNode(t, node.firstChild);
        }
        //有兄弟节点，递归兄弟节点
        if (node.nextSibling != null) {
            return findNode(t, node.nextSibling);
        }
        //递归停止
        return node;
    }

    static class TreeNode<T> {
        T data;
        TreeNode<T> nextSibling;
        TreeNode<T> firstChild;

        TreeNode(T data) {
            this.data = data;
        }

        TreeNode(T data, TreeNode<T> nextSibling) {
            this(data);
            this.nextSibling = nextSibling;
        }

        TreeNode(T data, TreeNode<T> nextSibling, TreeNode<T> firstChild) {
            this(data, nextSibling);
            this.firstChild = firstChild;
        }
    }

}
