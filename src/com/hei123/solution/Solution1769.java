package com.hei123.solution;

import java.util.Arrays;

public class Solution1769 {

    public static void main(String[] args) {
        Solution1769 solution1769 = new Solution1769();
        int[] ints = solution1769.minOperations2("110");
        System.out.println(Arrays.toString(ints));
    }

    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            int countInPosition = boxes.charAt(i) - '0';
            if (countInPosition > 0) {
                for (int j = 0; j < boxes.length(); j++) {
                    //需要移动的举例
                    int abs = Math.abs(i - j);
                    result[j] = result[j] + abs;
                }
            }

        }
        return result;
    }

    /**
     * 把所有数据移动到第i个位置=移动到前一个位置-
     *
     * @param boxes
     * @return
     */
    public int[] minOperations2(String boxes) {
        //用一个int数组记录左边球的个数 以及右边球的个数
        //两个for可以得到左右的数目
        int[] leftCount = new int[boxes.length()];
        int[] rightCount = new int[boxes.length()];
        for (int i = 1; i < boxes.length(); i++) {
            int countInPosition = boxes.charAt(i - 1) - '0';
            leftCount[i] = leftCount[i - 1] + countInPosition;
        }
        //同时计算出第0个需要的数据
        int cost0 = 0;
        for (int i = boxes.length() - 2; i >= 0; i--) {
            int countInPosition = boxes.charAt(i + 1) - '0';
            if (countInPosition > 0) {
                cost0 = cost0 + i + 1;
            }
            rightCount[i] = rightCount[i + 1] + countInPosition;
        }
        //开始计算结果
        int[] result = new int[boxes.length()];
        result[0] = cost0;
        for (int i = 1; i < boxes.length(); i++) {
            int count = boxes.charAt(i) - '0';
            result[i] = result[i - 1] + leftCount[i] - rightCount[i] - count;
        }
        return result;
    }
}
