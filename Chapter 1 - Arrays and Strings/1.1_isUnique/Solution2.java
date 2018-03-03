package com.michalgraczykowski;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {

    public boolean isUnique(String word) {
        if (word == null) {
            return true;
        }

        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (chars.contains(c)) {
                return false;
            } else {
                chars.add(c);
            }
        }
        return true;
    }
}