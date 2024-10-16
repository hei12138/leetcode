package com.hei123.solution.leetcode;

public class S55跳跃游戏 {

    public static void main(String[] args) {
        S55跳跃游戏 s55跳跃游戏 = new S55跳跃游戏();
        int[] pos = new int[]{0};
        boolean b = s55跳跃游戏.canJump(pos);
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
