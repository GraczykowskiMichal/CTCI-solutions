package com.michalgraczykowski;

public class Solution {

    public void urlify(char[] word, int trueLength) {
        final int finalLength = calculateFinalLength(word, trueLength);
        int insertIndex = finalLength - 1;
        for (int i = trueLength - 1; i >= 0; i--) {
            insertIndex = recomputeWord(i, insertIndex, word);
        }
    }

    private int calculateFinalLength(char[] word, int trueLength) {
        int spacesCount = 0;
        for (int i = 0; i < trueLength; i++) {
            char currentChar = word[i];
            if (currentChar == ' ') {
                spacesCount++;
            }
        }
        return trueLength + 2*spacesCount;
    }

    private int recomputeWord(int wordIndex, int insertIndex, char[] word) {
        char current = word[wordIndex];
        if (current != ' ') {
            word[insertIndex] = current;
            return insertIndex - 1;
        } else {
            insertSpace(insertIndex, word);
            return insertIndex - 3;
        }
    }

    private void insertSpace(int index, char[] word) {
        word[index] = '0';
        word[index - 1] = '2';
        word[index - 2] = '%';
    }
}