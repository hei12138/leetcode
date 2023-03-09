package com.hei123.solution;

public class Solution55 {

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        int[] pos = new int[]{0};
        boolean b = solution55.canJump(pos);
        System.out.println(b);
    }

    public boolean canJump(int[] nums) {

        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxPos) {
                return false;
            }
            if (i + nums[i] > maxPos) {
                maxPos = i + nums[i];
            }
        }
        if (maxPos >= nums.length - 1) {
            return true;
        }
        return false;
    }
}
