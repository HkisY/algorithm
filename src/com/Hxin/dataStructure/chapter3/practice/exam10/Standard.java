package com.Hxin.dataStructure.chapter3.practice.exam10;

import java.io.File;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/16
 */
public class Standard {
    public static void main(String[] args) {
        Standard L = new Standard();
        File f = new File("src");
        L.list(f);
    }

    public void list(File f) {
        list(f, 0);
    }

    public void list(File f, int depth) {
        printName(f, depth);
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            for (File i : files)
                list(i, depth + 1);
        }
    }

    void printName(File f, int depth) {
        String name = f.getName();
        for (int i = 0; i < depth; i++)
            System.out.print("	");
        if (f.isDirectory())
            System.out.println("Dir: " + name);
        else
            System.out.println(f.getName() + " " + f.length());
    }
}
