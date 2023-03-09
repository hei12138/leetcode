package com.hei123.solution;

public class Solution31 {

    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();

        int[] arr = {1,1};
        solution31.nextPermutation(arr);
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找到一个靠右的较小值
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            //从右边找一个比较小值大的 较大值
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
