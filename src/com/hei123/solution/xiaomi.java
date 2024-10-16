package com.hei123.solution;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.function.ToIntFunction;

public class xiaomi {
    public static void main(String[] args) {
        Integer[] integers = {3,8,0,5,1};
        xiaomi xiaomi = new xiaomi();
        List<List<Integer>> result=new ArrayList<>();
        xiaomi.dfs(integers,0,0,new ArrayDeque<>(),result);
        System.out.println();
    }

    public void dfs(Integer[] values, int curPosition, int curDeep, Deque<Integer> curTemp, List<List<Integer>> result) {
        if (curPosition > values.length - 1) {
            //节点终止
            if (sum(curTemp) == 12) {
                result.add(new ArrayList<>(curTemp));
            }
            return;
        }
        //加入当前节点
        if (values[curPosition] == null) {
            //节点终止
            if (sum(curTemp) == 12) {
                result.add(new ArrayList<>(curTemp));
            }
            return;
        }
        curTemp.add(values[curPosition]);
        //拿到子节点
        int leftPos = curPosition + curDeep * 2 + 1;
        int rightPos = curPosition + curDeep * 2 + 1;
        dfs(values, leftPos, curDeep + 1, curTemp, result);
        dfs(values, rightPos, curDeep + 1, curTemp, result);
        curTemp.removeLast();
    }

    public int sum(Deque<Integer> temp) {
        int sum = temp.stream().mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
        }).sum();
        return sum;
    }
}
