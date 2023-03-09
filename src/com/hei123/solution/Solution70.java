package com.hei123.solution;

public class Solution70 {


    public static void main(String[] args) {
        int n = 17;
        int f = f(n);
        System.out.println(f);
    }

    public static int f(int n) {
        //改 动态规划
        int[] cache = new int[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];

    }

    //爬楼梯问题 递归改带缓存的递归
}
