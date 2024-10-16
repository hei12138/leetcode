package com.hei123.solution.leetcode;

import java.util.*;

public class S51N皇后 {

    public List<List<String>> solveNQueens(int n) {
        HashSet<Integer> columns = new HashSet<>();
        HashSet<Integer> diagonals1 = new HashSet<>();
        HashSet<Integer> diagonals2 = new HashSet<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> result = new ArrayList<>();
        backtrace(n, 0, queens, result, columns, diagonals1, diagonals2);
        return result;
    }

    public void backtrace(int n, int row, int[] queens, List<List<String>> result,
                          Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (n == row) {
            result.add(generate(queens));
        }
        //隐含 每行 只有一个皇后得含义
        for (int i = 0; i < n; i++) {
            //之前是否有放过
            if (columns.contains(i)) {
                continue;
            }
            int diagonal1 = row - i;
            if (diagonals1.contains(diagonal1)) {
                continue;
            }
            int diagonal2 = row + i;
            if (diagonals2.contains(diagonal2)) {
                continue;
            }
            //放到当前位置
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            queens[row] = i;
            backtrace(n, row + 1, queens, result, columns, diagonals1, diagonals2);
            columns.remove(i);
            queens[row] = -1;
            diagonals1.remove(diagonal1);
            diagonals2.remove(diagonal2);
        }
    }

    public List<String> generate(int[] queue) {
        int n = queue.length;
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int pos = queue[i];
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[pos] = 'Q';
            result.add(new String(chars));
        }
        return result;
    }
}
