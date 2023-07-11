package com.Hxin.dataStructure.chapter4.practice.exam20;

import com.Hxin.dataStructure.chapter4.quadraticProbing.QuadraticProbingHashTable;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/5/24
 */
public class Map<K, V> {
    private QuadraticProbingHashTable<Entry<K, V>> items;

    public Map() {
    }

    public void put(K key, V value) {
        Entry<K,V> temp = new Entry<>(key,value);
        items.insert(temp);
    }

    public V get(K key) {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }


    public void makeEmpty() {
    }

    private static class Entry<K, V> {
        K key;
        V value;
        //Appropriate Constructors,etc
        Entry(){
        }
        Entry(K key,V value){
            this.key = key;
            this.value= value;
        }
    }
}
