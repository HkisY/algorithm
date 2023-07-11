package com.Hxin.dataStructure.chapter2.practice.exam4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/7
 */
public class Exam4<T extends Comparable<? super T>> {
    public static void main(String[] args) {
        Exam4 exam4 = new Exam4();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(31);

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(6);
        list2.add(14);
        list2.add(29);

//        List<Integer> listResult = exam4.unionTwoListNotChangeSource(list1, list2);
//        List<Integer> listResult = exam4.unionTwoListByMe(list1, list2);
        List<Integer> listResult = new ArrayList<>();
//        intersection(list1,list2,listResult);
        union(list1,list2,listResult);
        for (int i = 0; i < listResult.size(); i++) {
            System.out.print(listResult.get(i) + " ");
        }

    }

    public static <T extends Comparable<? super T>> void intersection(List<T> L1, List<T> L2,
                                                                                  List<T> Intersect) {
        ListIterator<T> iterL1 = L1.listIterator();
        ListIterator<T> iterL2 = L2.listIterator();

        T itemL1 = null, itemL2 = null;
        // get first item in each list
        if (iterL1.hasNext() && iterL2.hasNext()) {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        }

        while (itemL1 != null && itemL2 != null) {
            int compareResult = itemL1.compareTo(itemL2);

            if (compareResult == 0) {
                Intersect.add(itemL1);
                itemL1 = iterL1.hasNext() ? iterL1.next() : null;
                itemL2 = iterL2.hasNext() ? iterL2.next() : null;
            } else if (compareResult < 0) {
                itemL1 = iterL1.hasNext() ? iterL1.next() : null;

            } else {
                itemL2 = iterL2.hasNext() ? iterL2.next() : null;
            }
        }
    }

    //this answer is wrong, but the struct of method is great
    public static <T extends Comparable<? super T>> void union(List<T> L1, List<T> L2,
                                                                           List<T> Result) {
        ListIterator<T> iterL1 = L1.listIterator();
        ListIterator<T> iterL2 = L2.listIterator();
        T itemL1 = null, itemL2 = null;
        // get first item in each list
        if (iterL1.hasNext() && iterL2.hasNext()) {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        }
        while (itemL1 != null && itemL2 != null) {
            int compareResult = itemL1.compareTo(itemL2);
            if (compareResult == 0) {
                Result.add(itemL1);
                itemL1 = iterL1.hasNext() ? iterL1.next() : null;
                itemL2 = iterL2.hasNext() ? iterL2.next() : null;
            } else if (compareResult < 0) {
                Result.add(itemL1);
                itemL1 = iterL1.hasNext() ? iterL1.next() : null;
            } else {
                Result.add(itemL2);
                itemL2 = iterL2.hasNext() ? iterL2.next() : null;
            }
        }
    }

    public List<T> unionTwoListByMe(List<T> firstList, List<T> secondList) {
        List<T> result = new ArrayList<>();
        Iterator<T> iterator;
        List<T> tempList;
        int size = 0;
        if (firstList.get(firstList.size() - 1).compareTo(secondList.get(secondList.size() - 1)) > 0) {
            iterator = firstList.iterator();
            size = secondList.size();
            tempList = secondList;
        } else {
            iterator = secondList.iterator();
            size = firstList.size();
            tempList = firstList;
        }
        int flag = 0;
        while (iterator.hasNext()) {
            T t = iterator.next();
            result.add(t);
            for (int i = flag; i < size; i++) {
                if (t.compareTo(tempList.get(i)) > 0) {
                    result.add(tempList.get(i));
                } else if (t.compareTo(tempList.get(i)) == 0) {
                    i = i + 1;
                    flag = i;
                    break;
                } else {
                    flag = i;
                    break;
                }
            }
        }
        return result;

    }

    //all lists are sorted
    public List<T> unionTwoListNotChangeSource(List<T> firstList, List<T> secondList) {
        List<T> result = new ArrayList<>();
        Iterator<T> iterator;
        Iterator<T> secondIterator;
        if (firstList.get(firstList.size() - 1).compareTo(secondList.get(secondList.size() - 1)) > 0) {
            iterator = firstList.iterator();
            secondIterator = secondList.iterator();
        } else {
            iterator = secondList.iterator();
            secondIterator = firstList.iterator();
        }
        T t2 = null;
        if (secondIterator.hasNext()) {
            t2 = secondIterator.next();
        }
        //secondList 末尾元素指示器，只会添加一次
        int flag = 0;
        while (iterator.hasNext()) {
            T t1 = iterator.next();
            result.add(t1);

            if (t1.compareTo(t2) == 0) {
                if (secondIterator.hasNext()) {
                    t2 = secondIterator.next();
                } else {
                    continue;
                }
            }
            if (!secondIterator.hasNext()) {
                if (flag == 0) {
                    result.add(t2);
                    flag++;
                }
                continue;
            }

            while (t1.compareTo(t2) > 0) {
                result.add(t2);
                if (secondIterator.hasNext()) {
                    t2 = secondIterator.next();
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
