package com.hei123.solution.leetcode;

public class S198打家劫舍 {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] result = new int[length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            result[i] = Math.max(nums[i], result[i - 2] + nums[i]);
        }
        return result[length - 1];
        //对于只有一个房间的，最大值就是偷第一家
        //两个房间的
        //三个房间的，偷第二家，result[i-1]
        //三个房间的，头第一家和第三家 result[i-2]+n[i]
    }
}
