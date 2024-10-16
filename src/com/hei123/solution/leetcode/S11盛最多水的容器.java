package com.hei123.solution.leetcode;

public class S11盛最多水的容器 {

    public static void main(String[] args) {
        S11盛最多水的容器 s11盛最多水的容器 = new S11盛最多水的容器();
        int[] height = {1, 1};
        int i = s11盛最多水的容器.maxArea(height);
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
