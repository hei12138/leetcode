package com.hei123.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

public class S78子集 {
    public static void main(String[] args) {
        S78子集 s78子集 = new S78子集();
        List<List<Integer>> subsets = s78子集.subsets(new int[]{1, 2,3,4});
        System.out.println(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        recurse(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void recurse(int[] nums, int pos, List<Integer> temp, List<List<Integer>> result) {
        if (pos >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        //不选择该元素
        recurse(nums, pos + 1, temp, result);
        //选择该元素
        temp.add(nums[pos]);
        recurse(nums, pos + 1, temp, result);
        temp.remove(temp.size() - 1);
    }

    /**
     * 用bfs做
     *
     */
    public static void bfs() {
        String arg = "abcd";
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= arg.length() - 1; i++) {
            bfsdeep(arg, "", i, result);
        }
        System.out.println(result);
    }

    public static void bfsdeep(String arg, String temp, int cur, List<String> result) {
        if (cur > arg.length() - 1) {
            return;
        }
        temp = temp + arg.charAt(cur);
        result.add(temp);
        //a ab ac ad
        for (int i = cur; i < arg.length(); i++) {
            bfsdeep(arg, temp, i + 1, result);
        }
    }
}
