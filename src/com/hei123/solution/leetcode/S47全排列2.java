package com.hei123.solution.leetcode;

import java.util.*;

/**
 * 有重复数字的全排列，排列不能重复
 */
public class S47全排列2 {


    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 3};
        List<List<Integer>> permute = permute(ints);
        System.out.println(permute);

    }

    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> resultList = new ArrayList<>();
        ArrayList<Integer> currentResult = new ArrayList<>();
        backtrack(resultList, currentResult, new boolean[nums.length], 0, nums);
        return resultList;
    }

    /**
     * 填空法
     *
     * @param result
     * @param currentResult
     * @param pos
     * @param
     */
    public static void backtrack(List<List<Integer>> result, List<Integer> currentResult, boolean[] visited, int pos, int[] nums) {
        if (pos == nums.length) {
            result.add(new ArrayList<>(currentResult));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //这里可以判断的时候用!visit[i-1]和visit[i-1]都可以
            //区别就是同层剪枝和非同层剪枝
            //假设用!visit[i-1]
            //           1
            //       2   2x   3
            //     2  3
            //假设用visit[i-1]
            //             1
            //       2     2     3
            //     2x  3  2  3
            //           3   2
            //换个思路，如果前一个数字还未出现过，那么这个数字也不能用，如果已经出现了，那么就可以用了
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }

            visited[i] = true;
            currentResult.add(nums[i]);
            backtrack(result, new ArrayList<>(currentResult), visited, pos + 1, nums);
            visited[i] = false;
            currentResult.remove(currentResult.size() - 1);

        }

    }
}
