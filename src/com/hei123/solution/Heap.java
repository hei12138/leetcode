package com.hei123.solution;

/**
 * 堆
 */
public class Heap {

    public static void main(String[] args) {

    }

    public void pop(int[] arr) {
        //取出数据第一个元素
        int target = arr[0];
        //把最后一个元素放到第一个
        arr[0] = arr[arr.length - 1];
        maxHeapify(arr, 0, arr.length - 1);

    }

    public void buildHeap(int[] arr, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(arr, i, heapSize);
        }
    }

    public void maxHeapify(int[] arr, int pos, int heapSize) {
        //对当前的节点做堆化
        int left = pos * 2 + 1;
        int right = pos * 2 + 2;
        //拿最大的节点
        int largest = pos;
        if (left < heapSize && arr[left] > arr[pos]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > largest) {
            largest = right;
        }
        if (largest != pos) {
            //交换元素
            swap(arr, pos, largest);
            maxHeapify(arr, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
