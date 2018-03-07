package com.michalgraczykowski;

public class Solution2 {

    public void removeDups(Node head) {
        Node prev = head;
        while (prev != null) {
            removeValues(prev.value, prev, prev.next);
            prev = prev.next;
        }
    }

    private void removeValues(int value, Node prev, Node from) {
        Node current = from;
        while (current != null) {
            Node next = current.next;
            if (current.value == value) {
                prev.next = next;
                current = next;
            } else {
                prev = current;
                current = next;
            }
        }
    }
}