package com.Hxin.dataStructure.chapter0.practice.Exam14;

/**
 * @author Hxin
 * @version 1.0
 * @see
 * @since 2022/4/4
 */
public class Animal {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
