package com.michalgraczykowski;

public class Solution {

    public boolean isOneAway(String s1, String s2) {
        return isAway(s1, s2, 1);
    }

    private boolean isAway(String s1, String s2, int howMuch) {
        if (howMuch == 0) {
            return s1.equals(s2);
        }

        if (s1.length() < s2.length()) { // s1 is longer, s2 is shorter
            String t = s1;
            s1 = s2;
            s2 = t;
        }

        int lengthDiff = s1.length() - s2.length(); // length diff
        if (lengthDiff > howMuch) {
            return false;
        }

        int firstDiffIndex = firstDiffIndex(s1, s2);
        if (lengthDiff == 0) {
            return isAway(s1.substring(firstDiffIndex + 1), s2.substring(firstDiffIndex + 1), howMuch - 1);
        } else {
            return isAway(s1.substring(firstDiffIndex + 1), s2.substring(firstDiffIndex), howMuch - 1);
        }
    }

    private int firstDiffIndex(String longer, String shorter) { //return index of first difference between 2 strings
        int i = 0, minLength = shorter.length();
        while (i < minLength) {
            if (longer.charAt(i) != shorter.charAt(i)) {
                return i;
            }
            i++;
        }
        return i;
    }
}