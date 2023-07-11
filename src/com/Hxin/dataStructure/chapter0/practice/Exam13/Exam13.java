package com.Hxin.dataStructure.chapter0.practice.Exam13;

/**
 * @author Hxin
 * @version 1.0
 * @see
 * @since 2022/4/2
 */
public class Exam13 {
    public static void main(String[] args) {
        Collection<String> s = new Collection<>();
        s.insert("hello");
        s.insert("World");
        System.out.println(s.toString());
        System.out.println(s.isEmpty());
        s.remove("hello");
        System.out.println(s.toString());
        System.out.println(s.isPresent("World"));
        s.remove("World");
        System.out.println(s.toString());
        s.isEmpty();
        s.insert("Leeeee");
        System.out.println(s.toString());
        s.makeEmpty();
        System.out.println(s.toString());
        s.isEmpty();
        s.insert("a");
        s.insert("a");
        s.insert("a");
        s.insert("a");
        System.out.println(s.toString());

    }
}
