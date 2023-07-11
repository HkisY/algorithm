package com.Hxin.dataStructure.chapter2.practice.exam3;

import com.Hxin.dataStructure.chapter2.listADT.linkedList.MyLinkedList;

import java.util.Iterator;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/7
 */
public class Exam3<T> extends MyLinkedList<T> {
    private final MyLinkedList<T> list;
    Exam3(){
       list = new MyLinkedList<>();
    }

    public MyLinkedList<T> getList() {
        return list;
    }


    public boolean containsByMe(T t){
        for (T value : list) {
            if (value.equals(t)) {
                return true;
            }
        }
        return false;
    }

    public int containsReturnIndex(T t){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Exam3<Integer> exam = new Exam3<>();
        exam.getList().add(1);
        exam.getList().add(2);
        exam.getList().add(3);
        System.out.println(exam.containsByMe(1));
        System.out.println(exam.containsReturnIndex(1));
        System.out.println(exam.containsReturnIndex(2));



    }
}
