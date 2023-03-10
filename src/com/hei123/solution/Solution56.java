package com.hei123.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        List<int[]> result = new ArrayList<>();
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            //判断是否能覆盖
            //因为是按左边界排序的
            //构建新边界
            //如果temp的右边界没有超过下一个的左边界，需要构建新的
            if (temp[1] < interval[0]) {
                result.add(temp);
                temp = interval;
            } else {
                //延长边界
                temp[0] = Math.min(temp[0], interval[0]);
                temp[1] = Math.max(temp[1], interval[1]);
            }
        }
        result.add(temp);
        return result.toArray(new int[result.size()][]);
    }
}
