package com.hei123.solution;

/**
 * 最长公共子序列
 */
public class Solution1143 {

    public int longestCommonSubsequence(String text1, String text2) {

        //使用动态规划
        //dp[i][j]代表text1中以i结尾的子序列和text2中以j结尾的子序列的最长公共子序列长度
        //如果text1[i]==text2[j] 其最长子序列的长度为dp[i-1][j-1]+1
        //如果text1[i]！=text2[j] 其最长子序列的长度为math.max(dp[i-1][j],dp[i][j-1])
        //以i结尾的子序列的最后一个字符是text1[i-1]
        //如abc,cbc
        //dp[0][2]代表的是""和cb进行比较
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                char c1 = text1.charAt(i - 1);
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
