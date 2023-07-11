package com.Hxin.dataStructure.chapter4.practice.exam5;

/**
 * LinkedList.java - a singly linked list implementation to support separate chaining hash tables.
 * The intent here is not to implement all methods in the Java API List interface - just the ones needed to support the
 * separate chaining implementation given in section 5.3 in the text.
 * We need the following:
 * default constructor
 * clear()
 * contains()
 * add()
 * remove()
 *
 * @author Hxin
 * @version 1.0
 * @since 2022/5/19
 */
public class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {
        head = null;
    }

    public void clear() {
        head = null;
    }

    /**
     * contains:We assume type T has an appropriate equals method.
     */
    public boolean contains(T value) {
        boolean found = false;
        for (Node<T> curr = head; curr != null; curr = curr.next)
            if (curr.data.equals(value)) {
                return true;
            }
        return false;
    }

    public void add(T value) {
        Node<T> n = new Node<T>(value);
        // Special case of first node in list
        if (head == null) {
            head = n;
            head.next = null;
        } else {
            // Go to the end of the list
            Node<T> curr = null;
            for (curr = head; curr.next != null; curr = curr.next)
                ;
            // At this point, curr is the last node in the list before adding.
            curr.next = n;
            n.next = null;
        }
    }

    /**
     * remove:	If the value to be removed does not exist in the list,
     * then do nothing.
     * We assume that type T has an appropriate equals() method.
     */
    public void remove(T value) {
        if (this.contains(value)) {
            // Special case of removing the first node in the list.
            if (head.data.equals(value)) {
                head = head.next;
            } else {
                // At this point we know the value to remove is in the list,
                // but not at the head of the list.
                Node<T> victimPred = null;
                for (Node<T> curr = head; curr.next != null; curr = curr.next) {
                    if (curr.next.data.equals(value)) {
                        victimPred = curr;
                        break;
                    }
                }
                // Now, remove the victim node.
                // The node victimPred is the node preceding the victim.
                assert victimPred != null;
                victimPred.next = victimPred.next.next;
            }
        }
    }

    /**
     * print:	a means to print the list contents
     */
    public void print() {
        for (Node<T> curr = head; curr != null; curr = curr.next) {
            System.out.printf("%s\t", curr.data.toString());
        }
        System.out.print("\n");
    }
}
