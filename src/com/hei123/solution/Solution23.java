package com.hei123.solution;

public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        //顺序合并
//        ListNode ans = null;
//        for (int i = 0; i < lists.length; i++) {
//            ans = mergeTwoList(ans, lists[i]);
//        }
//        return ans;
        return merge(lists, 0, lists.length - 1);

    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        return mergeTwoList(merge(lists, l, mid), merge(lists, mid + 1, r));
    }


    public ListNode mergeTwoList(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        //开始遍历
        while (aPtr != null && bPtr != null) {
            if (aPtr.val > bPtr.val) {
                tail.next = bPtr;
                tail = tail.next;
                bPtr = bPtr.next;
            } else {
                tail.next = aPtr;
                tail = tail.next;
                aPtr = aPtr.next;
            }
        }
        //如果有一个为空了，直接拼接另一个
        tail.next = aPtr == null ? bPtr : aPtr;
        return head.next;
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
