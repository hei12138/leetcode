package com.hei123.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution46 {

    public static void main(String[] args) {
        int[] ints = {1,2,3};
        List<List<Integer>> permute = permute2(ints);
        System.out.println(permute);
    }

    public static List<List<Integer>> permute2(int[] nums) {
        ArrayList<Integer> currentResult = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        backtrack2(results,currentResult,nums,new boolean[nums.length],0);
        return results;
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

    /**
     * 填空法
     */
    public static void backtrack2(List<List<Integer>> resultList,
                                  List<Integer> currentResult, int[] nums,boolean[] visited, int pos){
        //有n个空，往n个空里填数据
        if(pos == nums.length){
            resultList.add(new ArrayList<>(currentResult));
        }
        //往空里填数据
        for (int j = 0; j < nums.length; j++) {
            if(visited[j]){
                continue;
            }
            //填第j个数字
            currentResult.add(nums[j]);
            visited[j] = true;
            backtrack2(resultList, currentResult, nums, visited, pos + 1);
            visited[j] = false;
            //移除当前数据
            currentResult.remove(currentResult.size() - 1);
        }
    }
}
