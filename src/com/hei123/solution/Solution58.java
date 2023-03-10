package com.hei123.solution;

public class Solution58 {

    public int lengthOfLastWord(String s) {
        //去除末尾空格
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            index--;
            wordLength++;
        }
        return wordLength;
    }
}
