package com.hei123.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution30 {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        Solution30 solution30 = new Solution30();
        solution30.findSubstring(s, words);

    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int m = words.length;
        int n = words[0].length();
        for (int i = 0; i < n; i++) {
            if (i + m * n > s.length()) {
                break;
            }
            Map<String, Integer> differ = new HashMap<>();
            for (int j = 0; j < m; j++) {
                //读取 wordCount个字符
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (int k = 0; k < words.length; k++) {
                differ.put(words[k], differ.getOrDefault(words[k], 0) - 1);
                if (differ.get(words[k]) == 0) {
                    differ.remove(words[k]);
                }
            }
            //开始滑动窗口
            for (int start = i; start < s.length() - m * n + 1; start = start + n) {
                if (start != i) {
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) {
                    res.add(start);
                }
            }
        }

        return res;
    }

}
