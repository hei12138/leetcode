package com.hei123.solution.leetcode;

public class S215数组中的第K个最大元素 {

    public static void main(String[] args) {
        S215数组中的第K个最大元素 s215数组中的第K个最大元素 = new S215数组中的第K个最大元素();
        int[] nums = {4, 2, 3, 8, 9, 1, 7, 10, 24, 12};
        int kthLargest = s215数组中的第K个最大元素.findKthLargest(nums, 3);
        System.out.println(kthLargest);
    }


    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildHeapDown(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            --heapSize;
            shiftDown(nums, 0, heapSize);
        }
        return nums[0];
    }

    //向下建堆
    public void buildHeapDown(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            shiftDown(nums, i, heapSize);
        }
    }

    public void shiftDown(int[] nums, int i, int heapSize) {
        int left = i * 2 + 1, right = i * 2 + 2, largest = i;
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            shiftDown(nums, largest, heapSize);
        }
    }

    public void shiftUp(int[] nums, int i, int heapSize) {
        //拿父节点
        int parent = i / 2, largest = i;
        if (nums[parent] < nums[i]) {
            largest = parent;
        }
        if (largest != i) {
            swap(nums, parent, largest);
            shiftUp(nums, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
