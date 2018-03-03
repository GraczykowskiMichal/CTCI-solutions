package com.michalgraczykowski;

public class Solution {

    public void rotate(int n, int[][] matrix) {
        int levelBound = (n + 1)/2;
        for (int level = 0; level < levelBound; level++) {
            rotateLevel(level, n, matrix);
        }
    }

    private void rotateLevel(int level, int n, int[][] matrix) {
        int columnBound = level + (n - 2 * level - 1);
        for (int column = level; column < columnBound; column++) {
            doSingleRotationStep(level, column, n, matrix);
        }
    }

    private class Pixel {
        int row, column;
        public Pixel(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    private void doSingleRotationStep(int row, int column, int n, int [][] matrix) {
        int buffer = matrix[row][column];
        for (int i = 0; i < 4; i++) {
            Pixel newPos = getNewPos(row, column, n);
            int temp = matrix[newPos.row][newPos.column];
            matrix[newPos.row][newPos.column] = buffer;
            buffer = temp;
            row = newPos.row;
            column = newPos.column;
        }
    }

    private Pixel getNewUnifiedPos(int unifiedRow, int unifiedColumn, int unifiedN) {
        int newUnifiedRow = unifiedColumn;
        int newUnifiedColumn = unifiedN - 1 - unifiedRow;
        return new Pixel(newUnifiedRow, newUnifiedColumn);
    }

    private Pixel getNewPos(int row, int column, int n) {
        int delta = row;
        int unifiedRow = 0;
        int unifiedColumn = column - row;
        int unifiedN = n - 2 * row;
        Pixel newUnifiedPos = getNewUnifiedPos(unifiedRow, unifiedColumn, unifiedN);
        return new Pixel(newUnifiedPos.row + delta, newUnifiedPos.column + delta);
    }
}