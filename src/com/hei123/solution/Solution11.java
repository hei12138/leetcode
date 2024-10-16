package com.hei123.solution;

import java.util.concurrent.locks.ReentrantLock;

public class Solution11 {

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[] height = {1, 1};
        int i = solution11.maxArea(height);
        System.out.println(i);
    }

    //双指针解法，每次向内移动短的那边，如将i->i+1,则相当与小曲(i,j-1),(i,j-2)...，这些都不会比(i,j)大
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = Math.min(height[left], height[right]) * (right - left);
        while (left != right) {
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
            //计算面积
            int temp = Math.min(height[left], height[right]) * Math.abs(right - left);
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }
}
