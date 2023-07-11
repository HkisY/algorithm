package com.Hxin.dataStructure.chapter4.practice.exam8;

import java.util.Random;

/**
 * Let's simulate linear, quadratic, and cubic probing.
 * Is cubic probing any better than quadratic?
 * In this simulation, cells equal to 0 represent empty, and cells
 * equal to 1 contain some key value.
 * @author Hxin
 * @version 1.0
 * @since 2022/5/24
 */
public class Solution {
    public static final int SIZE = 10000019;    // prime number
    public static final int MAX =  9000000;

    public static void main(String[] args) {
        int[] linear = new int[SIZE];
        int[] quadratic = new int[SIZE];
        int[] cubic = new int[SIZE];

        int linearCollisions = 0;
        int quadraticCollisions = 0;
        int cubicCollisions = 0;

        // We are going to generate random indices to occupy in the hash tables.
        Random gen = new Random();

        for (int i = 0; i < MAX; ++i) {
            int hashCode = gen.nextInt(SIZE);
            int offset = 0;
            while (linear[hashCode] == 1) {
                ++linearCollisions;
                ++offset;
                hashCode += offset;
                if (hashCode >= SIZE)
                    hashCode %= SIZE;
            }
            linear[hashCode] = 1;
        }

        for (int i = 0; i < MAX; ++i) {
            int hashCode = gen.nextInt(SIZE);
            int offset = 0;
            while (quadratic[hashCode] == 1) {
                ++quadraticCollisions;
                ++offset;
                hashCode += offset * offset;
                if (hashCode >= SIZE)
                    hashCode %= SIZE;
            }
            quadratic[hashCode] = 1;
        }

        for (int i = 0; i < MAX; ++i) {
            int hashCode = gen.nextInt(SIZE);
            int offset = 0;
            while (cubic[hashCode] == 1) {
                ++cubicCollisions;
                ++offset;
                hashCode += offset * offset * offset;
                if (hashCode >= SIZE)
                    hashCode %= SIZE;
            }

            cubic[hashCode] = 1;
        }

        System.out.printf("Here is the number of collisions for each type of probing.\n");
        System.out.printf("linear = %d\n", linearCollisions);
        System.out.printf("quadratic = %d\n", quadraticCollisions);
        System.out.printf("cubic = %d\n", cubicCollisions);
    }
}

/* Here are the results of an example run.	When trying to insert 9 million
 * elements, here is the number of collisions encountered:
 *	    linear	= 16,896,111
 *	    quadratic = 15,544,826
 *	    cubic	= 15,436,598
 * So, we can conclude that the cubic probing performs slightly better under
 * these conditions (large hash table, lambda up to 0.9)
 */
