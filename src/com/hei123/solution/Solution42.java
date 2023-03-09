package com.hei123.solution;

public class Solution42 {

    public int trap(int[] height) {
        //遍历得到亮哥数组，分别为i处位置，左边的最大值和右边的最大值
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        //从左到有遍历 得到左边
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return result;
    }
}
