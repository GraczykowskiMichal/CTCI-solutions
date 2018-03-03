package com.michalgraczykowski;

public class Solution {

    public void zero(int [][] matrix, int numberOfRows, int numberOfColumns) {
        boolean zeroFirstRow = false, zeroFirstColumn = false;

        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                if (matrix[row][column] == 0) {
                    if (row == 0) {
                        zeroFirstRow = true;
                    } else {
                        matrix[row][0] = 0;
                    }
                    if (column == 0) {
                        zeroFirstColumn = true;
                    } else {
                        matrix[0][column] = 0;
                    }
                }
            }
        }

        for (int row = 1; row < numberOfRows; row++) {
            if (matrix[row][0] == 0) {
                zeroWholeRow(matrix, row, numberOfColumns);
            }
        }
        for (int column = 1; column < numberOfColumns; column++) {
            if (matrix[0][column] == 0) {
                zeroWholeColumn(matrix, column, numberOfRows);
            }
        }

        if (zeroFirstRow) {
            zeroWholeRow(matrix, 0, numberOfColumns);
        }
        if (zeroFirstColumn) {
            zeroWholeColumn(matrix, 0, numberOfRows);
        }
    }

    private void zeroWholeRow(int [][] matrix, int row, int numberOfColumns) {
        for (int column = 0; column < numberOfColumns; column++) {
            matrix[row][column] = 0;
        }
    }

    private void zeroWholeColumn(int [][] matrix, int column, int numberOfRows) {
        for (int row = 0; row < numberOfRows; row++) {
            matrix[row][column] = 0;
        }
    }
}