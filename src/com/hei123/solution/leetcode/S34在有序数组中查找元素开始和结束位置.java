package com.hei123.solution.leetcode;

public class S34在有序数组中查找元素开始和结束位置 {

    public static void main(String[] args) {
        int[] ints = new int[]{5, 7, 7, 8, 8, 10};
        S34在有序数组中查找元素开始和结束位置 s34在有序数组中查找元素开始和结束位置 = new S34在有序数组中查找元素开始和结束位置();
        int[] ints1 = s34在有序数组中查找元素开始和结束位置.searchRange(ints, 8);
        System.out.println();
    }

    public int[] searchRange(int[] nums, int target) {

        int rightIdx = findFirstHigher(nums, target) - 1;
        int leftIdx = findFirstHigherOrEqual(nums, target);
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    //查找第一个大于该元素的位置
    public int findFirstHigher(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }

    //查找第一个大于或等于该元素的位置
    public int findFirstHigherOrEqual(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                pos = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return pos;
    }
}
