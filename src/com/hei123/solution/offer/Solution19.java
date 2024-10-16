package com.hei123.solution.offer;

import java.util.*;

public class Solution19 {

    public static void main(String[] args) {
        //使用递归来做
        Solution19 solution19 = new Solution19();
//        boolean aa = solution19.isMatch("", "c*c*");
//        System.out.println(aa);

        boolean aaa = solution19.isMatch2("aaa", "ac*");
    }

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (s.length() == 0) {

            if (p.length() >= 2 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2));
            }
            return false;
        }
        if (p.length() > 1 && p.charAt(1) == '*') {
            //匹配0次或//匹配多次
            return isMatch(s, p.substring(2))
                    || (match(s.charAt(0), p.charAt(0)) && isMatch(s.substring(1), p));

        } else {
            boolean match = match(s.charAt(0), p.charAt(0));
            if (!match) {
                return false;
            }
            return isMatch(s.substring(1), p.substring(1));
        }
    }

    public boolean match(char a, char b) {
        if (b == '.') {
            return true;
        }
        return a == b;
    }

    /**
     * 使用状态机来做
     * 以步数来做状态机，
     * 如果发现*，则前一个状态可以一直保持，也可以突破到下一个状态
     * 匹配最后如果有endstate，那么说明匹配成功
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        List<Tuple> state = new ArrayList<>();
        int curState = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                //前一个状态可以一直保持自己的状态
                state.get(curState - 1).f1.add(curState - 1);
            } else {
                HashSet<Integer> transforMap = new HashSet<>();
                transforMap.add(curState + 1);
                Tuple tuple = new Tuple(p.charAt(i), transforMap);
                state.add(tuple);
                curState++;
            }
        }
        int endState = curState + 1;
        state.get(state.size() - 1).f1.add(endState);
        return false;
    }

    public static class Tuple {
        public char f0;
        public Set<Integer> f1;

        public Tuple(char f0, Set<Integer> f1) {
            this.f0 = f0;
            this.f1 = f1;
        }
    }

    public enum State {
        INIT,
        ENTER_NEXT,
        DO_NOTHING,
        END;
    }

}
