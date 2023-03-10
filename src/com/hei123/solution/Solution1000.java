package com.hei123.solution;

import java.util.*;

public class Solution1000 {

    public static void main(String[] args) {
        Solution1000 solution1000 = new Solution1000();
        int[][] value = new int[5][];
        value[0] = new int[]{1, 1};
        value[1] = new int[]{2, 2};
        value[2] = new int[]{3, 3};
        value[3] = new int[]{4, 5};
        value[4] = new int[]{1, 6};
        int[][] sum = solution1000.sum(value);
        int[][] topk = solution1000.topk(sum, 3);
        for (int i = 0; i < topk.length; i++) {
            System.out.println(Arrays.toString(topk[i]));
        }

    }

    public int[][] topk(int[][] value, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < value.length; i++) {
            //最小堆
            if (i < k) {
                heap.offer(value[i]);
            } else {
                heap.offer(value[i]);
                heap.poll();
            }
        }
        int[][] result = new int[heap.size()][];
        int i = 0;
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            result[i] = poll;
            i++;
        }
        return result;
    }

    public int[][] sum(int[][] value) {
        HashMap<Integer, Integer> userValueMap = new HashMap<>();
        for (int i = 0; i < value.length; i++) {
            int userId = value[i][0];
            int userValue = value[i][1];
            if (!userValueMap.containsKey(userId)) {
                userValueMap.put(userId, 0);
            }
            userValueMap.put(userId, userValueMap.get(userId) + userValue);
        }
        int[][] result = new int[userValueMap.size()][];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : userValueMap.entrySet()) {
            Integer userId = entry.getKey();
            Integer value1 = entry.getValue();
            result[i] = new int[]{userId, value1};
            i++;
        }
        return result;
    }
}
