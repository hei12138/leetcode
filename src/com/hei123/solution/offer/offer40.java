package com.hei123.solution.offer;

public class offer40 {

    public static void main(String[] args) {
        int[] ints = {3, 5, 7, 2, 11, 8};
        offer40 offer40 = new offer40();
        offer40.getLeastNumbers(ints, 3);
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int partition = partition(arr, 0, arr.length - 1);
        return null;
    }


    //基于快排来做
    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    public void swap(int[] arr, int l, int r) {
        int i = arr[l];
        arr[l] = arr[r];
        arr[r] = i;
    }
}
