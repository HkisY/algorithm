package com.Hxin.dataStructure.chapter0.practice.Exam14;

/**
 * @author Hxin
 * @version 1.0
 * @see
 * @since 2022/4/4
 */
public class Student implements Comparable<Student>{
    private int grade;
    private String name;

    Student(){}

    Student(int grade,String name){
        this.grade = grade;
        this.name = name;
    }
    @Override
    public int compareTo(Student student) {
        return Integer.compare(this.getGrade(), student.getGrade());
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                ", name='" + name + '\'' +
                '}';
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
