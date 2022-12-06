package com.hei123.solution.dp;

public class Solution300 {

    public static void main(String[] args) {
        int[] ints = {10, 9, 2, 5, 3, 7, 101, 18};
        int f = f(ints, 3);
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

}
