package com.hei123.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution27 {

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        List<String> strings = solution27.generateParenthesis(2);
        System.out.println(strings);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        parenthesis(ans, "", n, n);
        return ans;
    }

    public void parenthesis(List<String> ans, String cur, int left, int right) {
        //什么情况下结束
        if (left == 0 && right == 0) {
            ans.add(cur);
            return;
        }
        if (left == right) {
            //只能加左括号
            parenthesis(ans, cur + "(", left - 1, right);
        } else {
            //可以加左括号或右括号,但是得先有左括号才行
            if (left > 0) {
                parenthesis(ans, cur + "(", left - 1, right);
            }
            parenthesis(ans, cur + ")", left, right - 1);
        }


    }
}
