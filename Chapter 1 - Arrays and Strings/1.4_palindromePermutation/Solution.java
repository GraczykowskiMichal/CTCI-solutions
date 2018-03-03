package com.michalgraczykowski;

public class Solution {

    public boolean isPalindromePermutation(String word) {
        word = word.toLowerCase();
        int validCount = countValidChars(word);
        int xorResult = xorAllValidChars(word);
        if (validCount % 2 == 0) {
            return xorResult == 0;
        } else {
            return parity(word, (char)xorResult) == 1;
        }
    }

    private interface WordCalculator {
        int calculate(int currentResult, char currentChar);
    }

    private int countValidChars(String word) {
        return wordIterator(word, ((result, currentChar) -> {
            if (isValid(currentChar)) {
                return result + 1;
            } else {
                return result;
            }
        }));
    }

    private int xorAllValidChars(String word) {
        return wordIterator(word, ((result, currentChar) -> {
            if (isValid(currentChar)) {
                return result ^ currentChar;
            } else {
                return result;
            }
        }));
    }

    private int parity(String word, char c) {
        return wordIterator(word, (result, currentChar) -> {
            if (currentChar == c) {
                return (result + 1) % 2;
            } else {
                return result;
            }
        });
    }

    private boolean isValid(char c) {
        return Character.isAlphabetic(c);
    }

    private int wordIterator(String word, Main.WordCalculator calculator) {
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            result = calculator.calculate(result, word.charAt(i));
        }
        return result;
    }
}