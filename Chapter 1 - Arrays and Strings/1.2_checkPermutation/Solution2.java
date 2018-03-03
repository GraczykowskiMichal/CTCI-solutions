package com.michalgraczykowski;

import java.util.Arrays;

public class Solution2 {

    public boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        } else {
            return sort(s1).equals(sort(s2));
        }
    }

    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}