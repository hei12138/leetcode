package com.hei123.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> ansList = new ArrayList<int[]>();
        boolean placed = false;
        for (int[] interval : intervals) {
            //在插入区间右侧且无交集
            if (interval[0] > right) {
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            }
            //在插入区间左侧且无交集
            if (interval[1] < left) {
                //没有交叉
                ansList.add(interval);
            } else {
                //有交集
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        return ansList.toArray(new int[ansList.size()][]);
    }
}
