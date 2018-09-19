package com.michalgraczykowski;

public class Solution {

    public <T extends Comparable<T>> LinkedListNode<T> partition(LinkedListNode<T> list, T value) {
        if (list == null) {
            return null;
        }
        LinkedListNode<T> head = list, tail = list, current = list.next;
        while (current != null) {
            LinkedListNode<T> next = current.next;
            if (current.value.compareTo(value) < 0) {
                LinkedListNode<T> prevHead = head;
                head = current;
                current.next = prevHead;
            } else {
                tail.next = current;
                tail = current;
            }
            current = next;
        }
        tail.next = null;
        return head;
    }
}
