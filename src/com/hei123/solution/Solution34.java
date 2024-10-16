package com.hei123.solution;

import java.util.Arrays;

public class Solution34 {

    public static void main(String[] args) {
        Solution34 sol = new Solution34();
        int[] ints = {1, 2, 3, 4, 5, 6};
        int[] ints1 = sol.searchRange1(ints, 5);
        System.out.println(Arrays.toString(ints1));
        int i = sol.searchRange2(ints, 5);
        System.out.println(i);
    }

    public int[] searchRange1(int[] nums, int target) {
        int left = -1;
        int right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (left == -1) {
                    left = i;
                }
                right = i;
            }
        }
        return new int[]{left, right};
    }

    /**
     * 写个二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchRange2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}
