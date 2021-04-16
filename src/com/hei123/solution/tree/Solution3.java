package com.hei123.solution.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 荣耀笔试题
 */
public class Solution3 {

    public static List<String> result = new ArrayList<>();

    private static int max = 0;

    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        max = n + k - 1;
        splitGift2(n, k-1, "");
        System.out.println(result.size());
        result.forEach(e -> {
            System.out.println(e);
        });
    }

    public static void splitGift2(int n, int k, String temp) {
        for (int i = 0; i < n + 1; i++) {
            if(k==0){
                //没人了，全给他
                for (int j=0;j<n;j++){
                    temp+="*";
                }
                result.add(temp);
                return;
            }
            for (int j = 0; j < i; j++) {
                temp += "*";
            }
            temp+="|";
            splitGift2(n-i,k-1,temp);
            temp="";
        }

    }

    public static void splitGift(int index, int n, int k, String temp) {
        //递归
        if (index == max) {
            result.add(temp);
            return;
        }
        if (n > 0) {
            //跟for循环类似，
            splitGift(index + 1, n - 1, k, temp + "*");
        }
        if (k > 0) {
            //如果还有人的话
            splitGift(index + 1, n, k - 1, temp + "|");
        }

    }
}
