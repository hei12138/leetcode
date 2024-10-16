package com.hei123.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        List<List<Integer>> subsets = solution78.subsets(new int[]{1, 2,2});
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
}
