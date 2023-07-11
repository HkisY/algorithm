package com.Hxin.dataStructure.chapter0.typeErasure;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/2
 */
public class TypeErasure {
    public static void main(String[] args) {
        MemoryCell<Integer> cell = new MemoryCell<>();
        cell.wirte(4);
        Object cellObject = cell;
        MemoryCell<String> cell1 = (MemoryCell<String>) cellObject;
        String read = cell1.read();
//        illegal
//        cell instanceof MemoryCell<Integer> ? ((MemoryCell<Integer>) cell) : null;

    }
}
