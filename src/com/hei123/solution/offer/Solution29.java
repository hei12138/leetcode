package com.hei123.solution.offer;

public class Solution29 {

    public int[] spiralOrder(int[][] matrix) {
        //按层打印
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int index = 0;
        int[] result = new int[rows * columns];
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            //第一行
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            for (int i = top + 1; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    result[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    result[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;

        }
        return result;
    }


}
