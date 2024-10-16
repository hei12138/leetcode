package com.hei123.solution;

public class Solution61 {

    public static void main(String[] args) {
        Solution61 solution61 = new Solution61();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
        solution61.rotateRight(listNode1, 2);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        //找到末尾节点
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        //闭合为环
        tail.next = head;
        //从头开始往右移动n个位置
        for (int i = 0; i < add; i++) {
            tail = tail.next;
        }
        ListNode next = tail.next;
        tail.next = null;
        return next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
