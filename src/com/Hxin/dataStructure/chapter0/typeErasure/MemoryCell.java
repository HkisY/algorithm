package com.Hxin.dataStructure.chapter0.typeErasure;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/2
 */
public class MemoryCell<T> {
    private T val;

    public T read() {
        return val;
    }

    public void wirte(T val) {
        this.val = val;
    }
}
