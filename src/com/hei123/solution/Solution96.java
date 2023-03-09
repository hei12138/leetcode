package com.hei123.solution;

public class Solution96 {

    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        int i = solution96.numTrees(3);
        System.out.println(i);
    }

    public int dpNumTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public int numTrees(int n) {
        int recurse = recurse(n);
        return recurse;
    }

    public int recurse(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            //以i为根节点能构成的数据
            //左子树的数量*右子树的数量
            int leftCount = recurse(i - 1);
            int rightCount = recurse(n - i);
            count += leftCount * rightCount;
        }
        return count;
    }

}
