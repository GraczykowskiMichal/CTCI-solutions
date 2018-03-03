package com.michalgraczykowski;

import java.util.Arrays;

public class Solution1 {

    public boolean isUnique(String word) {
        if (word == null || word.equals("")) {
            return true;
        }
        char[] chars = getSortedChars(word);
        char prev = chars[0];
        for (int i = 1; i < word.length(); i++) {
            if (prev == word.charAt(i)) {
                return false;
            } else {
                prev = word.charAt(i);
            }
        }
        return true;
    }

    private char[] getSortedChars(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return chars;
    }
}