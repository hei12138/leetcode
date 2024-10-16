package com.hei123.solution.leetcode;

public class S10正则表达式匹配 {

    private int[][] tempResult;

    public static void main(String[] args) {
        S10正则表达式匹配 s10正则表达式匹配 = new S10正则表达式匹配();
        String s = "aa";
        String p = "a*";
        s10正则表达式匹配.tempResult = new int[s.length()][p.length()];
        boolean match = s10正则表达式匹配.isMatch2(s, p);
        System.out.println(match);
    }

    /**
     * 递归写法 主要就是匹配.*时的三种选择，匹配0次，匹配1次，匹配多次
     * 从后往前匹配
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        //使用递归解法
        //什么时候结束递归
        if (p.length() == 0) {
            return s.length() == 0;
        }
        char c = p.charAt(p.length() - 1);
        if (s.length() == 0) {
            if (c == '*') {
                return isMatch(s, p.substring(0, p.length() - 2));
            }
            return false;
        }
        char d = s.charAt(s.length() - 1);
        if (c == '*') {
            //读取上一个字符
            char c1 = p.charAt(p.length() - 2);
            //匹配0次，匹配1次，匹配多次
            boolean match = charMatch(d, c1);
            if (match) {
                //s消去，p不消，匹配多次
                boolean tmpResult = isMatch(s.substring(0, s.length() - 1), p);
                //s消去，p消去，匹配1次
                if (!tmpResult) {
                    tmpResult = isMatch(s.substring(0, s.length() - 1), p.substring(0, p.length() - 2));
                }
                //s不消，p消去，匹配0从
                if (!tmpResult) {
                    tmpResult = isMatch(s, p.substring(0, p.length() - 2));
                }
                return tmpResult;
            } else {
                return isMatch(s, p.substring(0, p.length() - 2));
            }

        } else {
            boolean b = charMatch(d, c);
            if (b) {
                //递归
                return isMatch(s.substring(0, s.length() - 1), p.substring(0, p.length() - 1));
            }
        }
        return false;
    }

    public boolean isMatch2(String s, String p) {
        //从前往后
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (s.length() != 0) {
            boolean match = charMatch(s.charAt(0), p.charAt(0));
            if (p.length() >= 2 && p.charAt(1) == '*') {
                //三种选择 =>实际上只有两种选择
                //1. s去掉一位，p不变，
                //2. 或者s不变，p去掉2位
                //第三中情况 s去掉一位，p去掉2位可以转换为当前选择1，下次递归选择2
                if (match) {
                    boolean match2 = isMatch2(s, p.substring(2));
                    if (!match2) {
                        match2 = isMatch2(s.substring(1), p);
                    }
                    return match2;
                } else {
                    return isMatch2(s, p.substring(2));
                }

            } else {
                if (match) {
                    return isMatch2(s.substring(1), p.substring(1));
                } else {
                    return false;
                }
            }
        } else {
            if (p.length() >= 2 && p.charAt(1) == '*') {
                return isMatch2(s, p.substring(2));
            }
        }
        return false;

    }

    public boolean charMatch(char i, char t) {
        if (t == '.') {
            return true;
        } else if (i == t) {
            return true;
        }
        return false;
    }
}
