package com.hei123.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lishencai lisc@yealink.com
 * 二位数组螺旋遍历
 * @date 2021/3/15
 * @since 1.0.0
 */
public class S54螺旋矩阵 {

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        //按层次遍历
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                //从左到右
                result.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                //从上到下
                result.add(matrix[i][right]);
            }
            //最后一层可能只有一个节点
            if (left < right && top < bottom) {
                //从右到左
                for (int i = right - 1; i > left; i--) {
                    result.add(matrix[bottom][i]);
                }
                for (int i = bottom; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        return result;
    }
}
