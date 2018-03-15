package com.michalgraczykowski;

public class Solution {

    public Node kthToTheLast(Node head, int k) {
        if (k < 1) throw new IllegalArgumentException("k should be positive");
        int listLength = calculateLength(head);
        if (listLength < k) throw new IllegalArgumentException("k should be greater or equal to length of the list");
        return getElemAtPosition(head, listLength - k);
    }

    private int calculateLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    private Node getElemAtPosition(Node head, int position) {
        while (position > 0) {
            head = head.next;
            position--;
        }
        return head;
    }
}