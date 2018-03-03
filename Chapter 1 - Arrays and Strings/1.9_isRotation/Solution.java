package com.michalgraczykowski;

public class Solution {

    public boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String allPermutationsOfSecond = s2 + s2;
        return isSubstring(allPermutationsOfSecond, s1); //isSubstring is given
    }
}