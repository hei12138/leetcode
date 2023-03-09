package com.hei123.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        recurse(nums, 0, new HashSet<>(), new ArrayList<>(), result);
        return result;
    }

    public void recurse(int[] nums, int pos, Set<Integer> set, List<Integer> temp, List<List<Integer>> result) {
        if (pos >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (set.contains(nums[pos])) {
            //不选择该元素
            recurse(nums, pos + 1, set, temp, result);
        } else {
            //不选择该元素
            recurse(nums, pos + 1, set, temp, result);
            //选择该元素
            temp.add(nums[pos]);
            recurse(nums, pos + 1, set, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
