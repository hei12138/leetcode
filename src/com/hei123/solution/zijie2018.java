package com.hei123.solution;

import java.util.*;
import java.util.stream.Collectors;

public class zijie2018 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int userCount = 0;
        int questionCount = 0;
        List<String> questions = new ArrayList<>();
        String userLikeString = "";
        for (int i = 0; i < 3; i++) {
            String s = in.nextLine();
            if (i == 0) {
                userCount = Integer.parseInt(s);
            } else if (i == 1) {
                userLikeString = s;
            } else if (i == 2) {
                questionCount = Integer.parseInt(s);
            }
        }
        for (int i = 0; i < questionCount; i++) {
            String s = in.nextLine();
            questions.add(s);
        }
        int[] userLike = new int[userCount];
        String[] s1 = userLikeString.split(" ");
        for (int j = 0; j < s1.length; j++) {
            int i1 = Integer.parseInt(s1[j]);
            userLike[j] = i1;
        }
        for (int j = 0; j < questions.size(); j++) {
            String[] s = questions.get(j).split(" ");
            List<Integer> collect = Arrays.stream(s).map(Integer::parseInt).collect(Collectors.toList());
            Integer start = collect.get(0) - 1;
            Integer end = collect.get(1) - 1;
            Integer score = collect.get(2);
            int count = 0;
            for (int k = start; k <= end; k++) {
                if (userLike[k] == score) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public void swapString(String s, int m) {
        int length = s.length();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.get(s.charAt(i)).add(i);
            } else {
                map.put(s.charAt(i), new ArrayList<>());
                map.get(s.charAt(i)).add(i);
            }
        }
        int maxLength = 1;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> v = entry.getValue();
            int size = v.size();

            for (int i = 0; i < size; i++) {
                Integer ctr = v.get(i);
                int[] move = new int[size];
                for (int j = 0; j < size; j++) {
                    move[j] = Math.abs(v.get(j) - ctr);
                }
                Arrays.sort(move);
                int sum = 0;
                for (int k = 0; k < move.length; k++) {
                    sum += move[k];
                    if (sum > m) {
                        break;
                    }
                    if (k + 1 > maxLength) {
                        maxLength = k + 1;
                    }
                }
            }
        }
    }


}
