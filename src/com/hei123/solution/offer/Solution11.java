package com.hei123.solution.offer;

public class Solution11 {

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[] ints = {4, 5, 1, 2,3};
        solution11.minArray(ints);
    }

    public int minArray(int[] numbers) {
        //二分查找
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            //开始查找
            int mid = left + (right - left) / 2;
            int midValue = numbers[mid];
            int rightValue = numbers[right];
            if (rightValue < midValue) {
                //在右边
                left = mid + 1;
            }
            if (rightValue > midValue) {
                //在左边
                right = mid;
            }
            if (rightValue == midValue) {
                right--;
            }
        }
        return numbers[left];
    }
}
