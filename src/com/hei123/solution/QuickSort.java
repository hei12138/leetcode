package com.hei123.solution;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {9, 4, 2, 3, 5, 7, 6, 8, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition2(arr, left, right);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition + 1, right);
        System.out.println();
    }

    public int partition2(int[] arr, int left, int right) {
        //填坑法
        int pivot = arr[left];
        int index = left;
        while (left < right) {
            //从右边找一个比坑小的
            while (right > left && arr[right] > pivot) {
                right--;
            }
            arr[index] = arr[right];
            index = right;
            while (left < right && arr[left] < pivot) {
                left++;
            }
            arr[index] = arr[left];
            index = left;
        }
        arr[index] = pivot;
        return index;
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
