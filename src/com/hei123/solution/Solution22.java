package com.hei123.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        solution22.generateParenthesis(2);
    }

    /**
     * 根据n生成有效的括号组合
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList<>();
//        parenthesis(ans, "", n, n);
//        return ans;

        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void parenthesis(List<String> ans, String cur, int left, int right) {
        //结束
        if (left == 0 && right == 0) {
            ans.add(cur);
        }
        //left永远不能大于right
        if (left == right) {
            //只能加左括号
            parenthesis(ans, cur + "(", left - 1, right);
        } else {
            //可以加左或者右，但是加左括号的时候，得有左括号才行
            if (left > 0) {
                parenthesis(ans, cur + "(", left - 1, right);
            }
            parenthesis(ans, cur + ")", left + 1, right);
        }
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
