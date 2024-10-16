package com.hei123.solution.leetcode;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class S96不同的二叉搜索树 {

    public static void main(String[] args) {
        S96不同的二叉搜索树 s96不同的二叉搜索树 = new S96不同的二叉搜索树();
        int i = s96不同的二叉搜索树.numTrees(3);
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
