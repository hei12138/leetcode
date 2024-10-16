package com.hei123.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solutionallpath {

    public static void main(String[] args) {
        Solutionallpath solution2 = new Solutionallpath();
        String arg = "abcd";
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= arg.length() - 1; i++) {
            solution2.bfs(arg, "", i, result);
        }
        System.out.println(result);
    }

    public void bfs(String arg, String temp, int cur, List<String> result) {
        if (cur > arg.length() - 1) {
            return;
        }
        temp = temp + arg.charAt(cur);
        result.add(temp);
        //a ab ac ad
        for (int i = cur; i < arg.length(); i++) {
            bfs(arg, temp, i + 1, result);
        }
    }
}
