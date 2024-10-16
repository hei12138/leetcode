package com.hei123.solution.leetcode;

public class S79单词搜索 {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if (m == 0) {
            return false;
        }
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];

                boolean check = check(board, visited, i, j, word, 0);
                if (check) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int x, int y, String world, int index) {
        if (x < 0 || x > board.length - 1) {
            return false;
        }
        if (y < 0 || y > board[0].length - 1) {
            return false;
        }
        if (world.charAt(index) != board[x][y]) {
            return false;
        }
        //并且判断x,y是否已经被访问过
        if (visited[x][y]) {
            return false;
        }
        visited[x][y] = true;
        if (index == world.length() - 1) {
            return true;
        }
        //继续匹配
        boolean match = check(board, visited, x - 1, y, world, index+1)
                || check(board, visited, x + 1, y, world, index+1)
                || check(board, visited, x, y - 1, world, index+1)
                || check(board, visited, x, y + 1, world, index+1);
        if (!match) {
            visited[x][y] = false;
        }

        return match;
    }
}
