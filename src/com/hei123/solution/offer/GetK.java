package com.hei123.solution.offer;

public class GetK {

    /**
     * 给你无限个范围为 1~m 的数形成一个队列，问最少在前 n 个数的时候，可以通过加减
     * 法计算组合形成 K?(比如说 k=5,给你 2 和 3 可以形成，给你 4 4 3 也可以形成)
     *
     * @param args
     */
    public static void main(String[] args) {
        GetK a = new GetK();
        int[] ints = {4, 4, 3};
        a.doit(ints, 5);
        System.out.println();

    }


    /**
     * 再参考下leetcode754题，用数据规律取做
     * 为什么是delta/2呢，是因为总和s是加了的，当转变为-号时，相当于剪了2遍
     * @param arr
     * @param target
     */
    public void doit(int[] arr, int target) {
        //1. 那么问题就转换为 从这个数组里挑选出一些数据，在上面应用+或-能不能得到target
        //直接应用递归累加的方式，需要考虑负数，实际上还是对每一个数据应用+或-的过程
        boolean[][] dp = new boolean[arr.length][];
        //在每次循环的时候都记录下总数
        //确定第一次的大小
        boolean[] defaultValue = new boolean[arr[0] + 1];
        int firstTarget = arr[0];
        for (int i = 1; i < firstTarget; i++) {
            defaultValue[i] = false;
        }
        defaultValue[0] = true;
        defaultValue[firstTarget] = true;
        dp[0] = defaultValue;
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        //开始递推
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int oldSum = sum[i - 1];
            sum[i] = sum[i - 1] + num;
            boolean[] tempValue = new boolean[sum[i] + 1];
            dp[i] = tempValue;
            //应用+号或应用-号
            for (int j = 0; j < sum[i] + 1; j++) {
                //这里应该还要考虑负数
                if (j + num <= oldSum) {
                    dp[i][j] = dp[i - 1][j + num];
                } else if (j - num <= oldSum && j - num > 0) {
                    dp[i][j] = dp[i - 1][j - num];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        System.out.println();
    }
}
