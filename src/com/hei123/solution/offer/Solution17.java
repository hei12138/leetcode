package com.hei123.solution.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution17 {

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        int[] ints = solution17.printNumbers(1);
        System.out.println();
    }

    public int[] printNumbers(int n) {
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i <= 9; i++) {
            stack.offer("" + i);
        }
        for (int i = 1; i < n; i++) {
            //对stack中的所有元素拼接
            int size = stack.size();
            for (int j = 0; j < size; j++) {
                String poll = stack.poll();
                for (int h = 0; h <= 9; h++) {
                    String s = poll + h;
                    stack.offer(s);
                }
            }
        }
        int stackSize = stack.size() - 1;
        int[] result = new int[stackSize];
        String zero = stack.pollFirst();
        for (int i = 0; i < stackSize; i++) {
            String first = stack.pollFirst();
            Integer temp = Integer.valueOf(first);
            result[i] = temp;
        }
        return result;
    }
}
