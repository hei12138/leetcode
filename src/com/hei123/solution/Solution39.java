package com.hei123.solution;

import javax.swing.event.AncestorEvent;
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
        List<Integer> path2 = new ArrayList<>();
//        bfs(candidates, target, 0, path, res);
        search(candidates, target, 0, path2, res);

        //dfs(candidates, target, res, path2, 0);
        return res;
    }

    /**
     * 构建树节点的方式
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
     * 这个是一种构建二叉树的形式
     *
     * @param candidate
     * @param target
     * @param index
     * @param path
     * @param result
     */
    public void search(int[] candidate, int target, int index, List<Integer> path, List<List<Integer>> result) {
        if (index >= candidate.length) {
            return;
        }
        if (target == 0) {
            System.out.println(path);
            result.add(new ArrayList<>(path));
            return;
        }
        search(candidate, target, index + 1, path, result);
        //使用当前这个
        if (target - candidate[index] >= 0) {
            path.add(candidate[index]);

            search(candidate, target - candidate[index], index, path, result);
            path.remove(path.size() - 1);
        }
    }

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
