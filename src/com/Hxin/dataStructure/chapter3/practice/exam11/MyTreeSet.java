package com.Hxin.dataStructure.chapter3.practice.exam11;

import java.util.Iterator;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/17
 */


public class MyTreeSet<AnyType extends Comparable<? super AnyType>> {
    int modCount = 0;
    private BinaryNode<AnyType> root;

    public MyTreeSet() {
        root = null;
    }

    public Iterator<AnyType> iterator() {
        return new MyTreeSetIterator();
    }

    public void makeEmpty() {
        modCount++;
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType findMin() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        else
            return findMin(root).element;
    }

    public AnyType findMax() throws UnderflowException {
        if (isEmpty())
            throw new UnderflowException();
        else
            return findMax(root).element;
    }

    public void insert(AnyType x) {
        root = insert(x, root, null);
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    private void printTree(BinaryNode<AnyType> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }

    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0) return contains(x, t.right);
        else
            return true; // match
    }

    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null) return null;
        else if (t.left == null) return t;
        return findMin(t.left);
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t == null) return null;
        else if (t.right == null) return t;
        return findMax(t.right);
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t,
                                       BinaryNode<AnyType> pt) {
        if (t == null) {
            modCount++;
            return new BinaryNode<AnyType>(x, null, null, pt);
        }

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = insert(x, t.left, t);
        else if (compareResult > 0)
            t.right = insert(x, t.right, t);
        else
            ; // duplicate

        return t;
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return t; // not found
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) // two children
        {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            modCount++;
            /*
            the standard answer is wrong.... emmmmmm   if the node is the leaf node,then oneChild.parent will throw
            NullPointerException
            */
            BinaryNode<AnyType> oneChild;
            oneChild = (t.left != null) ? t.left : t.right;
            oneChild.parent = t.parent;    // update parent link
            t = oneChild;
        }
        return t;
    }

    static class UnderflowException extends Exception {
    }

    private static class BinaryNode<AnyType> {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
        BinaryNode<AnyType> parent;

        BinaryNode(AnyType theElement) {
            this(theElement, null, null, null);
        }

        BinaryNode(AnyType theElement,
                   BinaryNode<AnyType> lt, BinaryNode<AnyType> rt, BinaryNode<AnyType> pt) {
            element = theElement;
            left = lt;
            right = rt;
            parent = pt;
        }
    }

    private class MyTreeSetIterator implements java.util.Iterator<AnyType> {
        private BinaryNode<AnyType> current = findMin(root);
        private BinaryNode<AnyType> previous;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;
        private boolean atEnd = false;

        public boolean hasNext() {
            return !atEnd;
        }

        public AnyType next() {
            if (modCount != expectedModCount)
                throw new java.util.ConcurrentModificationException();

            if (!hasNext())
                throw new java.util.NoSuchElementException();

            AnyType nextItem = current.element;
            previous = current;

            //	if there is a right child, next node is min in right subtree
            if (current.right != null) {
                current = findMin(current.right);
            } else {
                // else, find ancestor that it is left of
                BinaryNode<AnyType> child = current;
                current = current.parent;
                while (current != null && current.left != child) {
                    child = current;
                    current = current.parent;
                }
                if (current == null) atEnd = true;
            }

            okToRemove = true;

            return nextItem;
        }

        public void remove() {
            if (modCount != expectedModCount)
                throw new java.util.ConcurrentModificationException();
            if (!okToRemove)
                throw new IllegalStateException();

            MyTreeSet.this.remove(previous.element);
            okToRemove = false;
        }
    }
}
