package com.Hxin.dataStructure.chapter3.binaryTree;

import java.util.NoSuchElementException;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/13
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contain(T t) {
        return contain(t, root);
    }

    public T findMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return findMin(root).data;
    }

    public T findMax() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return findMax(root).data;
    }

    public void insert(T t) {
        root = insert(t, root);
    }

    public void remove(T t) {
        root = remove(t, root);
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty Tree");
        } else {
            printTree(root);
        }
    }

    private boolean contain(T t, BinaryNode<T> node) {
        if (node == null) {
            return false;
        }
        int compareNum = t.compareTo(node.data);
        if (compareNum > 0) {
            return contain(t, node.right);
        } else if (compareNum < 0) {
            return contain(t, node.left);
        } else
            return true;
    }

    private BinaryNode<T> findMin(BinaryNode<T> node) {
        //while loop
        if (node != null) {
            while (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

    private BinaryNode<T> findMax(BinaryNode<T> node) {
        //recursive
        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        }
        return findMax(node.right);
    }

    /*
    assume the input data don`t have the common element
     */
    private BinaryNode<T> insert(T t, BinaryNode<T> node) {
        if (node == null) {
            return new BinaryNode<>(t, null, null);
        }
        int compareNum = t.compareTo(node.data);
        if (compareNum > 0) {
            node.right = insert(t, node.right);
        } else if (compareNum < 0) {
            node.left = insert(t, node.left);
        }
        //do nothing
        //this return value never used,aim to let the recursive continue,All recursive operation can end of this statement.
        return node;
    }


    /**
     * delete the node Physically
     *
     * @param t    data
     * @param node node
     * @return the new root of the subtree
     */

    private BinaryNode<T> remove(T t, BinaryNode<T> node) {
        if (node == null) {
            return null;  //not found
        }
        int compareNum = t.compareTo(node.data);
        //find the node which will be removed
        if (compareNum < 0) {
            node.left = remove(t, node.left);
        } else if (compareNum > 0) {
            node.right = remove(t, node.right);
        }
        //the node has two child, chose the right child`s most small node to replace the node
        else if (node.left != null && node.right != null) {
            //also can findMax(node.left )
            node.data = findMin(node.right).data;
            node.right = remove(node.data, node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    //delete the node logically (tombstone)->lazy deletion
    private BinaryNode<T> removeLogic(T t, BinaryNode<T> node) {
        return null;
    }

    private void printTree(BinaryNode<T> node) {
        //中序遍历
        if (node != null) {
            printTree(node.left);
            System.out.println(node.data);
            printTree(node.right);
        }
    }


    private static class BinaryNode<T> {
        T data;
        BinaryNode<T> left;
        BinaryNode<T> right;

        BinaryNode(T data) {
            this(data, null, null);
        }

        BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
