package com.hei123.solution.leetcode;

import java.util.Arrays;

/**
 * @author lishencai lisc@yealink.com
 * @date 2021/3/16
 * @since 1.0.0
 */
public class S59螺旋矩阵2 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(2)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        //按层次遍历
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                //从左到右
                result[top][i] = num;
                num++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                //从上到下
                result[i][right] = num;
                num++;
            }
            //最后一层可能只有一个节点
            if (left < right && top < bottom) {
                //从右到左
                for (int i = right - 1; i > left; i--) {
                    result[bottom][i] = num;
                    num++;
                }
                for (int i = bottom; i > top; i--) {
                    result[i][left] = num;
                    num++;
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
