package com.hei123.solution;

public class LIS {

    public static void main(String[] args) {

    }

    public int maxUpSubArr(int[] arr, int position) {
        //递归 这个只能求最长连续递增子序列
        if (position == 0) {
            return 1;
        }
        if (arr[position] >= arr[position] - 1) {
            return maxUpSubArr(arr, position - 1);
        } else {
            return 1;
        }
    }


    public int maxUpSubArrDp(int[] arr) {
        //dp[i]表示以i结尾的最长上升子序列 这个是最长连续上升子序列
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        return dp[arr.length - 1];
    }
}
