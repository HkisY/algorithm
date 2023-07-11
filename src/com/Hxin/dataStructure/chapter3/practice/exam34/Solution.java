package com.Hxin.dataStructure.chapter3.practice.exam34;


/**
 * We assume the existence of a method randInt (lower, upper) that generates a uniform random integer in the appropriate
 * closed interval.
 *
 * @author Hxin
 * @version 1.0
 * @since 2022/4/27
 */
public class Solution {
    public Node makeRandomTree(int lower, int upper) {
        Node t = null;
        int randomValue;

        if (lower <= upper)
            t = new Node(randomValue = randInt(lower, upper),
                    makeRandomTree(lower, randomValue - 1), makeRandomTree(randomValue + 1, upper));
        return t;
    }

    public Node makeRandomTree(int n) {
        return makeRandomTree(1, n);
    }

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int num,Node left,Node right){
            this.data = num;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * generate a uniform random integer between lower and upper
     * @param lower
     * @param upper
     * @return
     */
    private int randInt(int lower,int upper){
        int num = 0;
        return num;
    }
}
