package com.hei123.solution.leetcode;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class S279完全平方数 {

    public static int numSquares(int n) {
        //result[i]标识i最少有result[i]个数组成
        //对于n而言，其中j从0->根号n
        //result[n] =Math.min(result[n-j*j]+1)
        if (n == 0) {
            return 0;
        }
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                result[i] = Math.min(result[i], result[i - j * j] + 1);
            }
        }
        return result[n];
    }
}
