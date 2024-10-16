package com.hei123.solution.leetcode;

public class S91解码方法 {

    public int count = 0;

    public static void main(String[] args) {
        S91解码方法 s91解码方法 = new S91解码方法();
        int i = s91解码方法.numDecodings("226");
        System.out.println(i);
        int i1 = s91解码方法.dynamicPrograming("10011");
        System.out.println();
        int i2 = s91解码方法.numDecodings2("10011");
        System.out.println();
    }

    public int numDecodings(String s) {
        recurse(s, 0);
        return count;
    }

    public int numDecodings2(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    public int dynamicPrograming(String s) {
        int[] dp = new int[s.length()];
        if (s.charAt(0) == '0') {
            dp[0] = 0;
        } else {
            dp[0] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (i == 1) {
                if (s.charAt(0) == '0') {
                    dp[i] = 0;
                }else{
                    //是不是可以自己组
                    if (s.charAt(i) != '0') {
                        dp[i] += dp[i - 1];
                    }
                    //是否可以跟前一个组
                    if ((s.charAt(0) - '0') * 10 + (s.charAt(i) - '0') <= 26) {
                        dp[i] += dp[i - 1];
                    }
                }

            } else {
                if (s.charAt(i) == '0') {
                    //只能跟前一个组
                    if (s.charAt(i - 1) != '0' && (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26) {
                        dp[i] = dp[i - 2];
                    } else {
                        dp[i] = 0;
                    }
                } else {
                    //当前字符不为0
                    //自己组
                    dp[i] += dp[i - 1];
                    //是否能跟前一个组
                    if (s.charAt(i - 1) != '0' && (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26) {
                        dp[i] += dp[i - 2];
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }

    public void recurse(String s, int start) {
        //终止条件
        if (start == s.length()) {
            //没有数据了
            //终止
            count++;
            return;
        }
        //主要判断下一个数是不是0,是0的话就不能用
        int value = 0;
        if (s.charAt(start) == 0) {
            return;
        }
        for (int end = start; end < s.length(); end++) {
            value = value * 10 + (s.charAt(end) - '0');
            if (value > 0 && value <= 26) {
                recurse(s, end + 1);
            } else {
                break;
            }
        }

    }
}
