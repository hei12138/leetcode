package com.hei123.solution;

public class Solution03 {

    public int findRepeatNumber(int[] nums) {
        int[] temp = new int[nums.length];
        for (int num : nums) {
            if (temp[num] > 0) {
                return num;
            } else {
                temp[num] = 1;
            }
        }
        return 0;
    }
}
