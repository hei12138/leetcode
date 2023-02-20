package com.hei123.solution.array.solution1781;

import java.util.HashMap;

public class Solution1781 {

    public static void main(String[] args) {
        Solution1781 solution1781 = new Solution1781();
        int abaacc = solution1781.beautySum("aabcbaa");
        System.out.println(abaacc);
    }

    public int beautySum(String s) {
        int length = s.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            int[] ints = new int[26];
            int maxFreq = 0;
            for (int j = i; j < length; j++) {
                int x = s.charAt(j) - 'a';
                ints[x]++;
                maxFreq = Math.max(maxFreq, ints[x]);
                int minFreq = s.length();
                //获得最小值
                for (int k = 0; k < ints.length; k++) {
                    if (ints[k] > 0) {
                        minFreq = Math.min(minFreq, ints[k]);
                    }
                }
                result += (maxFreq - minFreq);
            }
        }
        return result;
    }
}
