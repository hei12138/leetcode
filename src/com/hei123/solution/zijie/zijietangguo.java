package com.hei123.solution.zijie;


public class zijietangguo {

    public static void main(String[] args) {
        zijietangguo zijietangguo = new zijietangguo();
        int i = zijietangguo.tangguo2();
        int[] ints = {1, 2, 4, 1, 3};
        int i1 = zijietangguo.tangguo1(ints);
    }

    /**
     * 字节糖果问题
     * 现有 5 个抽屉分别装有 1，2，4，1，3 个糖果，小明有三次取糖果的机会，而且每次只
     * 能从相邻的抽屉取，问小明要从哪个抽屉开始取糖果能获取最多糖果？（注：1.题目数据非
     * 正式数据，解题思路：如果用动态规划，如何实现？
     */
    public int tangguo1(int[] arr) {
        //这个题与连续子数组的最大和类似，连续子数组的最大和,那么f(i)=max(f(i-1)+num[i],num[i]);
        // 如果用动态规划的话，需要一点改动
        //用f(i)标识以第i个数结尾时，当前的最大和，f(i)=f(i-1)-num[i-3]+num[i]
        int max = 0;
        int position = 0;//记录位置
        for (int i = 0; i < 3; i++) {
            max += arr[i];
        }
        for (int i = 1; i < arr.length - 2; i++) {
            //计算从当前开始拿能得到的最大值
            int cur = max - arr[i - 1] + arr[i + 2];
            if (cur > max) {
                position = i;
                max = cur;
            }
        }
        return position;
    }

    /**
     * 小明要在街上一排互相相邻的糖果屋拿糖，但不能在两个相邻的糖果屋拿糖。给定一个
     * 数组列表，每个元素代表每间房子中的糖的数目，小明能看到所有屋的数据，走一遍所有糖
     * 果屋，最多能拿多少糖？
     */
    public int tangguo2() {
        int[] ints = {1, 3, 4, 5, 8, 10, 6};
        //int recursive = recursive(ints, ints.length - 1);
        int dp = dp(ints);
        return dp;
    }


    public int recursive(int[] arr, int cur) {
        //先来个递归吧
        //递归终止条件
        if (cur == 0) {
            return arr[0];
        }
        if (cur == 1) {
            return Math.max(arr[0], arr[1]);
        }
        int recursive = recursive(arr, cur - 1);
        int recursive1 = recursive(arr, cur - 2) + arr[cur];
        return Math.max(recursive1, recursive);
    }

    public int dp(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[arr.length - 1];
    }
}
