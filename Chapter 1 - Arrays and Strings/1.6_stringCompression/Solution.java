package com.michalgraczykowski;

public class Solution {

    public String stringCompression(String input) {
        int length = input.length();
        if (length == 0) {
            return input;
        }
        int i = 1, prevCounter = 1;
        char prevChar = input.charAt(0);
        StringBuilder compressedStringBuilder = new StringBuilder();
        while (i < length) {
            char currentChar = input.charAt(i);
            if (currentChar == prevChar) {
                prevCounter++;
            } else {
                compressedStringBuilder.append(prevChar);
                compressedStringBuilder.append(prevCounter);
                prevChar = currentChar;
                prevCounter = 1;
            }
            i++;
        }
        compressedStringBuilder.append(prevChar);
        compressedStringBuilder.append(prevCounter);
        String compressedString = compressedStringBuilder.toString();
        return compressedString.length() < input.length() ? compressedString : input;
    }
}