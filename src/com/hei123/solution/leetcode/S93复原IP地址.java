package com.hei123.solution.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class S93复原IP地址 {

    public static void main(String[] args) {
        S93复原IP地址 s93复原IP地址 = new S93复原IP地址();
        List<String> strings = s93复原IP地址.restoreIpAddresses("0000");
        System.out.println();
    }

    public void restoreUseLoop(String s){
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k < s.length(); k++) {
                    //在i j k 位置插入.
                    //检测是否为ip即可
                    String substring = s.substring(0, i);
                    String substring1 = s.substring(i, j);
                    String substring2 = s.substring(j, k);
                    String substring3 = s.substring(k);
                }
            }
        }

    }

    public List<String> restoreIpAddresses(String s) {
        int[] temp = new int[4];
        ArrayList<String> result = new ArrayList<>();
        restore(s, temp, 0, 0, result);
        return result;
    }
    //递归回溯

    public void restore(String s, int[] temp, int segId, int start, List<String> result) {
        if (segId == 4 && start == s.length()) {
            String collect = Arrays.stream(temp).mapToObj(String::valueOf).collect(Collectors.joining("."));
            result.add(collect);
            return;
        }
        if (segId == 4 || start == s.length()) {
            return;
        }
        if (s.charAt(start) == '0') {
            //必须为0
            temp[segId] = 0;
            restore(s, temp, segId + 1, start + 1, result);
        } else {
            //获取一段字符
            int addr = 0;
            for (int end = start; end < s.length(); end++) {
                addr = addr * 10 + (s.charAt(end) - '0');
                if (addr > 255) {
                    break;
                } else {
                    temp[segId] = addr;
                    restore(s, temp, segId + 1, end + 1, result);
                }
            }
        }


    }
}
