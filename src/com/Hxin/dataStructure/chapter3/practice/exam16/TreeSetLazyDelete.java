package com.Hxin.dataStructure.chapter3.practice.exam16;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/18
 */
public class TreeSetLazyDelete<T extends Comparable<? super T>> {
    private static int surviveNode;
    private static int deadNode;
    private BinaryNode<T> root;

    /*
    public method
     */
    public TreeSetLazyDelete() {
        root = null;
    }

    public void insert(T t) {
        root = insert(t, root,null);
    }

    public void remove(T t) {
        if (surviveNode / 2 < deadNode) {
            root = removeByPhysic(root);
        }
        root = remove(t, root);
    }

    /*
    private method
     */
    private BinaryNode<T> insert(T t, BinaryNode<T> node,BinaryNode<T> parent) {
        if (node == null) {
            surviveNode++;
            return new BinaryNode<>(t,null,null,parent,1);
        }

        int compareNum = t.compareTo(node.data);
        if (compareNum > 0) {
            node.right = insert(t, node.right,node);
        } else if (compareNum < 0) {
            node.left = insert(t, node.left,node);
        } else {
            if (node.nodeNum == 0) {
                node.nodeNum++;
                surviveNode++;
            } else {
                node.nodeNum++;
            }
        }
        return node;
    }

    public T findMaxWithoutFlag() {
        return findMaxWithoutIndicator(root).data;
    }

    public T findMinWithoutFlag() {
        return findMinWithoutIndicator(root).data;
    }

    private BinaryNode<T> findMaxWithoutIndicator(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        }
        return findMaxWithoutIndicator(node.right);
    }

    private BinaryNode<T> findMinWithoutIndicator(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        }
        return findMinWithoutIndicator(node.left);
    }

    public T findMax() {
//        BinaryNode<T> maxNode = findMaxWithoutIndicator(root);
        return findMax(root).data;
    }
    /*
    I can`t realize the method without the parentNode,I`m so vegetable(emmmmmm  chinglish is the best)
    one day latter.....
    WTF, this function is too hard to me
    TODO: 无父节点，逻辑删除节点，寻找最大值，递归调用实现
     */
    private BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node == null) {
            return null;
        }

        if (node.right==null){
            if (node.nodeNum >0){
                return node;
            }else if (node.left == null && node.nodeNum == 0){//has been deleted logically and don`t have child
                findMax(node.parent);//This loop needs to shield the right cycle
            } else if (node.nodeNum == 0) {  //has been deleted logically but has a left child
                return findMax(node.left);
            }
        }
        return findMax(node.right);
    }

    private BinaryNode<T> removeByPhysic(BinaryNode<T> node) {
        if (node == null) {
            return null; //not found
        }
        return null;
    }

    private BinaryNode<T> remove(T t, BinaryNode<T> node) {
        if (node == null) {
            return null;//not found
        }
        int compareNum = t.compareTo(node.data);
        if (compareNum > 0) {
            node.right = remove(t, node.right);
        } else if (compareNum < 0) {
            node.left = remove(t, node.right);
        } else {
            if (node.nodeNum == 1) {
                deadNode++;
            }
            if (node.nodeNum <= 0) {
                //allow user to operate the remove method when the node was deleted by logically
                node.nodeNum = 0;
            } else {
                node.nodeNum--;
            }
        }
        return node;
    }

    private static class BinaryNode<T> {
        private T data;
        private BinaryNode<T> left;
        private BinaryNode<T> right;
        private BinaryNode<T> parent;
        private int nodeNum;

        BinaryNode(T data) {
            this(data, null, null,null, 1);
        }

        BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right, BinaryNode<T> parent,int nodeNum) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.nodeNum = nodeNum;
        }
    }
}
