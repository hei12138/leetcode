package com.hei123.solution.offer;

import java.util.Stack;

public class Solution06 {

    public static void main(String[] args) {

    }

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> listNodes = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            listNodes.push(temp);
            temp = temp.next;
        }
        int[] result = new int[listNodes.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = listNodes.pop().val;
        }
        return result;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
