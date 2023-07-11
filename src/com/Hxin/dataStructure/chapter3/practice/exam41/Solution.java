package com.Hxin.dataStructure.chapter3.practice.exam41;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/5/17
 */
public class Solution {
    static class BinaryNode {
        int element;
        BinaryNode left;
        BinaryNode right;
        BinaryNode(){}

        BinaryNode(int element, BinaryNode left, BinaryNode right){
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    private void printNodeByLevelOrder(BinaryNode node){
        Queue<BinaryNode> queue = new LinkedList<>();
        if (node != null){
            queue.add(node);
        }
        while (!queue.isEmpty()){
            if (queue.peek().left!=null){
                queue.add(queue.peek().left);
            }
            if (queue.peek().right!=null){
                queue.add(queue.peek().right);
            }
            queue.poll();
        }
    }
}
