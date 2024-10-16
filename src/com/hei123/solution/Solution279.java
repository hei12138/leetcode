package com.hei123.solution;

public class Solution279 {

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
