package com.hei123.solution.leetcode;

import java.util.LinkedList;

public class S32最长有效括号 {

    public static int longestValidParentheses(String s) {
        int maxans=0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    stack.push(i);
                    continue;
                }
                //碰到右括号，且顶上元素为左括号，匹配上了
                if(s.charAt(stack.peek())=='('){
                    stack.pop();
                    int lastIndex=-1;
                    if(!stack.isEmpty()){
                        lastIndex = stack.peek();
                    }
                    maxans=Math.max(maxans,i-lastIndex);
                }else{
                    stack.push(i);
                }
            }
        }
        return maxans;
    }
}
