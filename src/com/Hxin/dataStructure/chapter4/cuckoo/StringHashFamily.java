package com.Hxin.dataStructure.chapter4.cuckoo;

import com.Hxin.dataStructure.chapter4.HashFamily;

import java.util.Random;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/5/19
 */
public class StringHashFamily implements HashFamily<String> {
    private final int[] MULTIPLIERS;
    private final Random r = new Random();

    public StringHashFamily(int d) {
        MULTIPLIERS = new int[d];
        generateNewFunctions();
    }

    @Override
    public int hash(String s, int which) {
        final int multiplier = MULTIPLIERS[which];
        int hashVal = 0;
        for (int i = 0; i < s.length(); i++) {
            hashVal = multiplier * hashVal + s.charAt(i);
        }
        return hashVal;
    }

    @Override
    public int getNumberOfFunctions() {
        return MULTIPLIERS.length;
    }

    @Override
    public void generateNewFunctions() {
        for (int i = 0; i < MULTIPLIERS.length; i++) {
            MULTIPLIERS[i] = r.nextInt();
        }
    }
}
