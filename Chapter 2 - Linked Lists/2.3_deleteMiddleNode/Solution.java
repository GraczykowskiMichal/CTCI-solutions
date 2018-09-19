package com.michalgraczykowski;

public class Solution {

    public void deleteMiddleNode(LinkedListNode node) {
        node.value = node.next.value;
        node.next = node.next.next;
    }
}
