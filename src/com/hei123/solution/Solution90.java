package com.hei123.solution;

import java.util.*;

public class Solution90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        recurse(false, nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void recurse(boolean choosePre, int[] nums, int pos, List<Integer> temp, List<List<Integer>> result) {
        if (pos >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        //不选择该元素
        recurse(false, nums, pos + 1, temp, result);
        if (!choosePre && pos > 0 && nums[pos - 1] == nums[pos]) {
            //如果前一个没选，并且这一个跟前一个一样的时候，这个也不能选，因为有另外一个分支选了前一个，如果再选这个就会重复
            return;
        }
        //选择该元素
        temp.add(nums[pos]);
        recurse(true, nums, pos + 1, temp, result);
        temp.remove(temp.size() - 1);
    }
}
