package com.hei123.solution.leetcode;


/**
 * 给你一个字符串 s，找到 s 中最长的
 * 回文
 * <p>
 * 子串
 * 。
 */
public class S05最长回文字串 {

    public static void main(String[] args) {
        S05最长回文字串 s05最长回文字串 = new S05最长回文字串();
        String babad = s05最长回文字串.longestPalindrome("cbbd");
        System.out.println(babad);
    }


    public String longestPalindrome(String s) {
        //中心扩展法
        int maxLength = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            //以它为起点，往两边扩
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end + 1);

    }

    public int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
