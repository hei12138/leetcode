package com.hei123.solution.offer2;

import com.hei123.solution.Solution1769;

public class Solution176 {

    public static void main(String[] args) {
        Solution176 solution176 = new Solution176();
        int[] a = {9, 4, 2, 3, 5, 7, 6, 8, 1};
        int kthLargest = solution176.findKthLargest(a, 4);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }


    public int quickSelect(int[] nums, int left, int right, int k) {
        //基于快排来做
        int pivot = partition(nums, left, right);
        if (pivot == k) {
            return nums[k];
        }
        if (pivot < k) {
            //在右边找
            return quickSelect(nums, pivot + 1, right, k);
        } else {
            //在左边找
            return quickSelect(nums, left, pivot - 1, k);
        }
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
