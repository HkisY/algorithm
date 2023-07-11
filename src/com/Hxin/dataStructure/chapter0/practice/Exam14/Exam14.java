package com.Hxin.dataStructure.chapter0.practice.Exam14;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/4
 */
public class Exam14 {
    public static void main(String[] args) {
        OrderedCollection<Student> students = new OrderedCollection<>();
        Student student1 = new Student(81, "Hxin");
        Student student2 = new Student(86, "Leeeeee");
        Student student3 = new Student(60, "Fei");
        Student student4 = new Student(78, "Qian");
        System.out.println(students.isEmpty());

        students.insert(student1);
        System.out.println(students.isEmpty());
        System.out.println(students.makeEmpty());
        System.out.println(students.isEmpty());


        students.insert(student1);
        students.insert(student2);
        students.insert(student3);
        students.insert(student4);
        System.out.println(students.remove(student4));

        students.insert(student4);
        System.out.println(students.findMax());
        System.out.println(students.findMin());

        System.out.println("--------------------");

        Rectangle rectangle1 = new Rectangle(30, 40);
        Rectangle rectangle2 = new Rectangle(20, 20);
        Rectangle rectangle3 = new Rectangle(20, 60);
        Rectangle rectangle4 = new Rectangle(10, 40);

        OrderedCollection<Rectangle> rectangles = new OrderedCollection<>();
        rectangles.insert(rectangle1);
        rectangles.insert(rectangle2);
        rectangles.insert(rectangle3);
        rectangles.insert(rectangle4);
        System.out.println(rectangles.findMax());
        System.out.println(rectangles.findMin());


//        OrderedCollection<Animal> animals = new OrderedCollection<Animal>();
    }
}
