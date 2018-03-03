package com.michalgraczykowski;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> charsCount = getCharsCount(s1);
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            Integer count = charsCount.get(c);
            if (count == null || count.equals(0)) {
                return false;
            }
            charsCount.put(c, count - 1);
        }
        return allValuesZeros(charsCount);
    }

    private Map<Character, Integer> getCharsCount(String word) {
        Map<Character, Integer> charsCount = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Integer currentCount = charsCount.get(c);
            if (currentCount == null) {
                charsCount.put(c, 1);
            } else {
                charsCount.put(c, currentCount + 1);
            }
        }
        return charsCount;
    }

    private boolean allValuesZeros(Map<Character, Integer> map) {
        for (Integer value: map.values()) {
            if (!value.equals(0)) {
                return false;
            }
        }
        return true;
    }
}