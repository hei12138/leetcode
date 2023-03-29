package com.hei123.solution;

public class Solution04 {

    public static void main(String[] args) {
        int[][] ints = new int[1][1];
        int[] ints1 = {-5};
        ints[0] = ints1;
        Solution04 solution04 = new Solution04();
        solution04.findNumberIn2DArray(ints, -5);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;

        int x = m - 1;
        int y = 0;
        while (x >= 0 && y < n) {
            int curValue = matrix[x][y];
            if (curValue == target) {
                return true;
            }
            if (curValue > target) {
                x--;
            }
            if (curValue < target) {
                y++;
            }
        }
        return false;
    }
}
