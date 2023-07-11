package com.Hxin.dataStructure.chapter2.stackADT;


import java.util.Arrays;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/10
 */
public class ArrayStackByMe<T> {
    private static final int INIT_CAPACITY = 10;
    private int theSize;
    private T[] theItems;
    private int topStack;

    public ArrayStackByMe() {
        doClear();
    }

    public static void main(String[] args) {
        ArrayStackByMe<Integer> solution = new ArrayStackByMe<>();
        solution.push(1);
        solution.push(2);
        System.out.println(solution);
        solution.push(1);
        solution.push(3);
        solution.push(2);
        System.out.println(solution);
        while (solution.hasNext()) {
            System.out.print(solution.top()+" ");
            System.out.print(solution.pop()+" ");
            System.out.println(solution);
        }
        System.out.println(solution);
    }

    public void clear() {
        doClear();
    }

    public T top(){
        return theItems[size()-1];
    }
    private void remove(){
        theItems[topStack] = null;
        theSize--;
    }
    private void doClear() {
        topStack = 0;
        theSize = 0;
        ensureCapacity(INIT_CAPACITY);
    }

    public void push(T t) {
        if (size() == theItems.length) {
            ensureCapacity(INIT_CAPACITY * 2);
        }
        theItems[size()] = t;
        topStack++;
        theSize++;
    }

    public T pop() {
        if (topStack < 0) {
            throw new IndexOutOfBoundsException();
        }
        T t = theItems[--topStack];
        remove();

        return t;
    }

    public int size() {
        return theSize;
    }

    public void ensureCapacity(int newCapacity) {
        //正常调用ensureCapacity，theSize必为0；此处防止违规访问
        if (newCapacity < theSize) {
            return;
        }
        T[] old = theItems;
        theItems = (T[]) new Object[newCapacity];
        topStack = size();

        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    public boolean hasNext() {
        return topStack > 0;
    }

    @Override
    public String toString() {
        return "ArrayStackByMe{" +
                "theSize=" + theSize +
                ", theItems=" + Arrays.toString(theItems) +
                ", topStack=" + topStack +
                '}';
    }
}
