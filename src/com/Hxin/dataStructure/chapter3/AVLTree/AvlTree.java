package com.Hxin.dataStructure.chapter3.AVLTree;


import java.util.NoSuchElementException;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/13
 */
public class AvlTree<T extends Comparable<? super T>> {
    private static final int ALLOWED_IMBALANCE = 1;
    private AvlNode<T> root;

    public AvlTree() {
        root = null;
    }
    /*
    public method
     */
    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public T findMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return findMin(root).data;
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
    /*
    private method
     */
    private void printTree(AvlNode<T> node) {
        //中序遍历
        if (node != null) {
            printTree(node.left);
            System.out.println(node.data);
            printTree(node.right);
        }
    }

    public static int height(AvlNode node) {
        return node == null ? -1 : node.height;
    }

    private AvlNode<T> insert(T t, AvlNode<T> node) {
        if (node == null) {
            return new AvlNode<>(t);
        }

        int compareNum = t.compareTo(node.data);
        if (compareNum < 0) {
            node.left = insert(t, node.left);
        } else if (compareNum > 0) {
            node.right = insert(t, node.right);
        }
        return balance(node);
    }

    private AvlNode<T> balance(AvlNode<T> node) {
        if (node == null) {
            return node;
        }
        if (height(node.left) - height(node.right) > ALLOWED_IMBALANCE) {
            if (height(node.left.left) >= height(node.left.right)) {
                node = rotateWithLeftChild(node);
            } else {
                node = doubleWithLeftChild(node);
            }
        } else if (height(node.right) - height(node.left) > ALLOWED_IMBALANCE) {
            if (height(node.right.right) >= height(node.right.left)) {
                node = rotateWithRightChild(node);
            } else {
                node = doubleWithRightChild(node);
            }
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    private AvlNode<T> doubleWithRightChild(AvlNode<T> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    private AvlNode<T> rotateWithRightChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.right), k2.height) + 1;
        return k1;
    }

    /*
    first child is left
    second child is right
     */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AvlNode<T> remove(T t, AvlNode<T> node) {
        if (node == null) {
            return node;
        }
        int compareNum = t.compareTo(node.data);
        if (compareNum < 0) {
            node.left = remove(t, node.left);
        } else if (compareNum > 0) {
            node.right = remove(t, node.right);
        } else if (node.left != null && node.right != null) {
            node.data = findMin(node.right).data;
            node.right = remove(node.data, node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return balance(node);
    }

    private AvlNode<T> findMin(AvlNode<T> node) {
        //while loop
        if (node != null) {
            while (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

    public static class AvlNode<T> {
        public T data;
        public AvlNode<T> left;
        public AvlNode<T> right;
        public int height;

        AvlNode(T data) {
            this(data, null, null);
        }

        AvlNode(T data, AvlNode<T> left, AvlNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
            height = 0;
        }
    }
}
