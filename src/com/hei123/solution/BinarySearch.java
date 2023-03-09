package com.hei123.solution;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearch binarySearch = new BinarySearch();
        int i = binarySearch.binarySearch(arr, 6);
        int i1 = binarySearch.searchFirstHigher(arr, 5);
    }

    //在排序数组中找一个等于它的值 假设增序
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }

    //找第一个比它大的元素
    public int searchFirstHigher(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;

    }

    //在排序旋转数组中找最小值
    public int searchStartInTransArr(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[right]) {
                right = mid;
            } else if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return arr[left];
    }
}
