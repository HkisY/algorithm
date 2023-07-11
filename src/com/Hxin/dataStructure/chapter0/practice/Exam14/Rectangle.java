package com.Hxin.dataStructure.chapter0.practice.Exam14;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/4
 */
public class Rectangle implements Comparable<Rectangle> {
    private int length;
    private int width;

    Rectangle() {
    }

    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public int compareTo(Rectangle rectangle) {
        int a = rectangle.getLength();
        int b = rectangle.getWidth();
        if (a * b == this.width * this.length) {
            return Integer.compare(this.width * this.length, a + b);
        } else if (a * b > this.width * this.length) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", area =" + length * width +
                '}';
    }
}
