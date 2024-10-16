package com.hei123.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 荣耀笔试题
 */
public class Solution荣耀 {

    public static List<String> result = new ArrayList<>();

    private static int max = 0;

    /**
     * n个苹果，分给k个人
     * 可以抽象为插隔板
     * *****
     * 在每个位置选择插或者不插隔板
     * @param args
     */
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        max = n + k - 1;
        //k为隔板数量
        splitGift(0, n, k-1, "");
        System.out.println(result.size());
        result.forEach(e -> {
            System.out.println(e);
        });
    }

    /**
     * 这个思路是基于分苹果来的，分一个苹果拼接一个*，
     * 不分的时候，加一个间隔
     * K为隔板数量
     * @param index
     * @param n
     * @param k
     * @param temp
     */
    public static void splitGift(int index, int n, int k, String temp) {
        //递归
        if (index == max) {
            result.add(temp);
            return;
        }
        if (n > 0) {
            //分
            splitGift(index + 1, n - 1, k, temp + "*");
        }
        if (k > 0) {
            //不分
            splitGift(index + 1, n, k - 1, temp + "|");
        }

    }
}
