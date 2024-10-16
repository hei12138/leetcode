package com.hei123.solution.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution40 {

    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        int[] ints = {1, 2, 8, 7, 6, 9, 4, 3, 2, 5};
//        solution40.quickSort(ints, 0, ints.length - 1);
//        solution40.partition(ints, 0, ints.length - 1);
        //solution40.randomizedSelected(ints, 0, ints.length - 1, 3);
        int[] b = solution40.getLeastNumbers(ints, 3);
        int[] a = solution40.getLeastNums2(ints, 3);
        System.out.println();
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //塞入数据
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            vec[i] = queue.poll();
        }
        return vec;
    }

    /**
     * 第k个最大的数
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNums2(int[] arr, int k) {
        int[] vec = new int[k];
        if (k == 0) { // 排除 0 的情况
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
            if (queue.size() > k) {
                //弹出最大的数
                queue.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            vec[i] = queue.poll();
        }
        return vec;

    }


    private void randomizedSelected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = partition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    public void quickSort(int[] arr, int l, int r) {
        //选择最左边的数
        if (l >= r) {
            return;
        }
        int left = l;
        int right = r;
        //获取到中间元素
        //我用左边的作为比对元素
        int compare = left;
        int mid = arr[compare];
        while (left < right) {
            //从右边找一个小于它的元素
            while (arr[right] >= mid && left < right) {
                right--;
            }
            arr[left] = arr[right];
            //从左边找一个大于它的元素
            while (arr[left] < mid && left < right) {
                left++;
            }
            //交换
            arr[right] = arr[left];
        }
        arr[left] = mid;
        quickSort(arr, l, left - 1);
        quickSort(arr, left + 1, r);
    }

    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                //i+1代表了第一个比这个元素大的位置
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
