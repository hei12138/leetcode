package com.hei123.solution.offer;

public class Solution22 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        //两次遍历，或者是双指针
        ListNode temp1 = head;
        ListNode temp2 = head;
        for (int i = 0; i < k; i++) {
            temp1 = temp1.next;
        }
        while (temp1 != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp2;

    }
}
