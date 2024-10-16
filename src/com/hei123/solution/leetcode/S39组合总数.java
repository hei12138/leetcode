package com.hei123.solution.leetcode;

import java.util.*;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合
 */
public class S39组合总数 {

    public static void main(String[] args) {
        S39组合总数 s39组合总数 = new S39组合总数();
        int[] ints = {3,8,5,1};
        List<List<Integer>> lists = s39组合总数.combinationSum(ints, 12);
        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        bfs(candidates, target, 0, path, res);
        return res;
//        List<List<Integer>> ans = new ArrayList<List<Integer>>();
//        List<Integer> combine = new ArrayList<Integer>();
//        dfs(candidates, target, ans, combine, 0);
//        return ans;
    }

    /**
     * 广度优先搜索
     *
     * @param candidates
     * @param target
     * @param begin
     * @param path
     * @param result
     */
    public void bfs(int[] candidates, int target, int begin, Deque<Integer> path, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
        }
        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            bfs(candidates, target - candidates[i], i, path, result);
            path.removeLast();
        }
    }


    /**
     * 深度优先搜索
     * @param candidates
     * @param target
     * @param ans
     * @param combine
     * @param idx
     */
    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
}
