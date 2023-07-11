package com.Hxin.dataStructure.chapter3.practice.exam11;

import java.util.Iterator;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/17
 */
public class TreeSetByMe<T extends Comparable<? super T>> implements Iterable<T> {
    private BinaryNode<T> root;
    private BinaryNode<T> parent;

    TreeSetByMe() {
        doClear();
    }

    /*
    public method
     */
    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        doClear();
    }

    public boolean add(T data) {
        if (contains(data)) {
            return false;
        } else {
            root = add(data, root);
            return true;
        }
    }

    public void remove(T data) {
        root = remove(data, root);
    }

    public boolean contains(T data) {
        return contains(data, root);
    }

    public void containNode(T data) {
        BinaryNode<T> tBinaryNode = containReturnNode(data, root);
        System.out.println(tBinaryNode == null ? -1 : tBinaryNode.data);
    }

    public Iterator<T> iterator() {
        return new TreeSetIterator();
    }

    /*
    private method
     */
    private void doClear() {
        root = null;
    }

    /**
     * find the node which it`s ele.compareTo(data) = 0
     *
     * @param data T data
     * @param node node
     * @return if the ele has been found，return the node,otherwise return null
     */
    private BinaryNode<T> containReturnNode(T data, BinaryNode<T> node) {
        if (node == null) {
            return null;
        }
        int compareNum = data.compareTo(node.data);
        if (compareNum > 0) {
            return containReturnNode(data, node.right);
        } else if (compareNum < 0) {
            return containReturnNode(data, node.left);
        } else {
            return node;
        }
    }

    private boolean contains(T data, BinaryNode<T> node) {
        if (node == null) {
            return false;
        }
        int compareNum = data.compareTo(node.data);
        if (compareNum > 0) {
            return contains(data, node.right);
        } else if (compareNum < 0) {
            return contains(data, node.left);
        } else {
            return true;
        }
    }

    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null) return null;
        else if (node.left == null) return node;
        return findMin(node.left);
    }

    private BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node == null) return null;
        else if (node.right == null) return node;
        return findMax(node.right);
    }

    private BinaryNode<T> remove(T data, BinaryNode<T> node) {
        if (node == null) {
            return null;//not found
        }
        int compareNum = data.compareTo(node.data);
        if (compareNum > 0) {
            node.right = remove(data, node.right);
        } else if (compareNum < 0) {
            node.left = remove(data, node.left);
        } else if (node.left != null && node.right != null) {
            node.data = findMin(node.right).data;
            //fix the right child tree
            node.right = remove(node.data, node.right);
        } else if (node.left == null && node.right == null) {
            node = null;
        } else {
            BinaryNode<T> oneChild;
            oneChild = (node.left != null) ? node.left : node.right;
            oneChild.parent = node.parent;    // update parent link
            node = oneChild;
        }
        return node;
    }

    private BinaryNode<T> add(T data, BinaryNode<T> node) {
        if (node == null) {
            return new BinaryNode<>(data, null, null, parent);
        }
        int compareNum = data.compareTo(node.data);
        if (compareNum < 0) {
            parent = node;
            node.left = add(data, node.left);
        } else if (compareNum > 0) {
            parent = node;
            node.right = add(data, node.right);
        }
        return node;
    }

    private static class BinaryNode<T> {
        T data;
        BinaryNode<T> left;
        BinaryNode<T> right;
        BinaryNode<T> parent;

        BinaryNode(T data) {
            this(data, null, null, null);
        }

        BinaryNode(T data, BinaryNode<T> left,
                   BinaryNode<T> right,
                   BinaryNode<T> parent) {
            this.left = left;
            this.right = right;
            this.data = data;
            this.parent = parent;
        }

        BinaryNode(BinaryNode<T> node, BinaryNode<T> parent) {
            this(node.data, node.left, node.right, parent);
        }
    }

    /*
    infix
     */
    class TreeSetIterator implements Iterator<T> {
        //need add an indicator which bans add or remove node in the process of the iterator
        //need add an indicator which release the remove operation when iterator invoke the next() method
        //@see MyTreeSet
        private BinaryNode<T> current = findMin(root);
        private BinaryNode<T> previous;
        private boolean isEnd = false;

        @Override
        public boolean hasNext() {
            return !isEnd;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            T result = current.data;
            previous = current;
            if (current.right != null) {
                current = findMin(current.right);
            } else {
                //memory the accessed node
                BinaryNode<T> memoFlag = current;
                current = current.parent;
                //sorted set need prefix foreach,so the statement current.left != memoFlag is the only way to judge the node
                //had been accessed(emmmmmm in fact, it`s just I only think of this one)
                while (current != null && current.left != memoFlag) {
                    memoFlag = current;
                    current = current.parent;
                }
            }

            if (current == null) isEnd = true;

            return result;
        }

        @Override
        public void remove() {
            TreeSetByMe.this.remove(previous.data);
        }
    }
}
