package com.hei123.solution;

import java.util.Arrays;

/**
 * @author lishencai lisc@yealink.com
 * @date 2021/3/16
 * @since 1.0.0
 */
public class Solution474 {

    public static void main(String[] args) {
        System.out.println(findMaxForm());
    }

    public static int findMaxForm() {
        int[] weight = {1,2,3,4};
        int[] value = {2,4,8,16};
        int capacity = 4;
        int[][] dp = new int[weight.length + 1][capacity + 1];
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j >= weight[i-1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i-1]] + value[i-1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[weight.length][capacity];
    }
}
