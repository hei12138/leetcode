package com.hei123.solution;

public class Solution21 {

    public int[] exchange(int[] nums) {
        //双指针，左边找偶数，右边找奇数，再交换位置
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            //找到第一个偶数
            while (left < right && (nums[left] % 2) == 1) {
                left++;
            }
            while (left < right && (nums[right] % 2) == 0) {
                right--;
            }
            //交换左右数据
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
        return nums;
    }
}
