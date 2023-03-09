package com.hei123.solution;

import java.util.*;

public class Solution39 {

    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        int[] ints = {2, 3, 7};
        List<List<Integer>> lists = solution39.combinationSum(ints, 7);
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
        dfs(candidates, target, 0, path, res);
        //search(candidates, target, 0, path, res);
        return res;
    }

    /**
     * 构建树节点的方式
     * @param candidates
     * @param target
     * @param begin
     * @param path
     * @param result
     */
    public void dfs(int[] candidates, int target, int begin, Deque<Integer> path, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
        }
        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, result);
            path.removeLast();
        }
    }

    /**
     * 这个是一种构建二叉树的形式，不过需要去重，因为可能选到重复的
     * @param candidate
     * @param target
     * @param cur
     * @param path
     * @param result
     */
    public void search(int[] candidate, int target, int cur, Deque<Integer> path, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
        }
        if (cur >= candidate.length) {
            return;
        }
        //使用当前这个
        path.add(candidate[cur]);
        search(candidate, target - candidate[cur], cur, path, result);
        path.removeLast();
        search(candidate, target, cur + 1, path, result);

    }
}
