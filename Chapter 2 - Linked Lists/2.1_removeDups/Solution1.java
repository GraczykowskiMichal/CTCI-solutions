package com.michalgraczykowski;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    public void removeDups(Node head) {
        if (head == null) {
            return;
        }
        Set<Integer> seen = new HashSet<>();
        seen.add(head.value);
        Node prev = head, current = head.next;
        while (current != null) {
            Node next = current.next;
            if (seen.contains(current.value)) {
                prev.next = next;
            } else {
                seen.add(current.value);
                prev = current;
            }
            current = next;
        }
    }
}