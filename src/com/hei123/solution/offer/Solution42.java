package com.hei123.solution.offer;

import java.util.concurrent.locks.ReentrantLock;

public class Solution42 {

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        solution42.maxSubArray(ints);
    }

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}
