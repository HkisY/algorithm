package com.Hxin.dataStructure.chapter3.practice.exam10;

import java.io.File;
import java.util.TreeSet;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/16
 */
public class Solution {
    public static void list(String fileName) {
        File file = new File(fileName);
        list(file, 0);
    }

    private static void list(File file, int depth) {
        printFileName(file, depth);
        if (file.isDirectory()){
            File[] list = file.listFiles();
            for (File f : list){
                list(f,depth+1);
            }
        }
    }
    private static void printFileName(File file, int depth) {
        String fileName = file.getName();
        for (int i = 0; i < depth; i++) {
            System.out.print("      ");
        }
        if (file.isDirectory()) {
            System.out.println("Dir: " + fileName);
        } else {
            System.out.println(fileName + "       " + file.length());
        }
    }

    public static void main(String[] args) {
        Solution.list("src");
    }

}
