package com.Hxin.dataStructure.chapter0.functionObject;

/**
 * @author Hxin
 * @version 1.0
 * @see
 * @since 2022/4/2
 */
public class TestProgram {
    public static void main(String[] args) {
        String[] arr = {"ZEBRA","alligator","crocodile"};
        System.out.println(FunctionA.findMax(arr,new CaseInsensitiveCompare()));
    }
}
