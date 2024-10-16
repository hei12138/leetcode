package com.hei123.solution.zijie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列问题
 * 123的全排列
 */
public class Solution0827全排列 {

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> currentResult = new ArrayList<>();
        for (int num : nums) {
            currentResult.add(num);
        }
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, currentResult, nums.length, 0);
        return results;
    }

    public static void backtrack(List<List<Integer>> resultList, List<Integer> currentResult, int n, int pos) {
        if (pos == n) {
            resultList.add(new ArrayList<>(currentResult));
        }
        //需要包含自己和自己交换，这样才能满足全部条件
        for (int i = pos; i < n; i++) {
            Collections.swap(currentResult, pos, i);
            backtrack(resultList, currentResult, n, pos + 1);
            Collections.swap(currentResult, pos, i);
        }
    }
}
