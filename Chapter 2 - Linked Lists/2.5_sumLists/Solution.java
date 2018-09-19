package com.michalgraczykowski;

import javafx.util.Pair;

public class Solution {

    public Node sumLists(Node list1, Node list2) {
        Node resultHead = null, resultTail = null;
        int list1Value, list2Value, carry = 0;
        while (list1 != null || list2 != null) {
            if (list1 != null) {
                list1Value = list1.value;
                list1 = list1.next;
            } else {
                list1Value = 0;
            }
            if (list2 != null) {
                list2Value = list2.value;
                list2 = list2.next;
            } else {
                list2Value = 0;
            }
            Pair<Node, Integer> sumResult = sumValuesIntoNode(list1Value, list2Value, carry);
            Node resultNode = sumResult.getKey();
            if (resultHead == null) {
                resultHead = resultNode;
                resultTail = resultNode;
            } else {
                resultTail.next = resultNode;
                resultTail = resultNode;
            }
            carry = sumResult.getValue();
        }
        if (carry != 0) {
            resultTail.next = new Node(carry);
        }
        return resultHead;
    }

    private Pair<Node, Integer> sumValuesIntoNode(int value1, int value2, int carry) {
        int result = value1 + value2 + carry;
        return new Pair<>(new Node(result % 10), result / 10);
    }
}
