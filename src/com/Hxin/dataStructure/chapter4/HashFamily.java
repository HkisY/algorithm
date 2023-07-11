package com.Hxin.dataStructure.chapter4;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/5/19
 */
public interface HashFamily<T> {

    int hash(T t, int which);

    int getNumberOfFunctions();

    void generateNewFunctions();
}
