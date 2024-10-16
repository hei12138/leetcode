package com.hei123.solution.leetcode;

public class S53最大子数组和 {

    public int maxSubArray(int[] nums) {
        // check param validation.
        if(nums == null || nums.length == 0)
            return 0;

        int sum = 0;
        int max = Integer.MIN_VALUE;

        // iterate nums array.
        for (int i = 0; i < nums.length; i++)
        {
            // choose a larger one between current number or (previous sum + current number).
            //如果之前的值为负数 那么自然是从当前值开始
            // 如果为正数 当前值为负数 并不妨碍 相当于给本次循环添加了一个值，但是最大值并未改变
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);    // choose the larger max.
        }

        return max;
    }
}
