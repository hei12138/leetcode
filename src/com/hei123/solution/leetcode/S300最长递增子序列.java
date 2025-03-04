package com.hei123.solution.leetcode;

public class S300最长递增子序列 {

    public static void main(String[] args) {
        int[] ints = {10, 9, 2, 5, 3, 7, 101, 18};
        int f = f(ints, ints.length-1);
        System.out.println(f);
    }

    public static int f(int[] nums, int i) {
        int a = 1;
        for (int j = 0; j < i; ++j) {
            if (nums[j] < nums[i]) {
                a = Math.max(a, f(nums, j) + 1);
            }

        }
        return a;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

}
