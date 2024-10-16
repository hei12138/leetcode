package com.hei123.solution.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class S25K个一组翻转链表 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        S25K个一组翻转链表 s25K个一组翻转链表 = new S25K个一组翻转链表();
        //ListNode listNode3 = solution25.reverseByStack(listNode);
        //ListNode listNode4 = solution25.inplaceReverse(listNode);
        ListNode listNode = s25K个一组翻转链表.reverseKGroup(listNode1, 3);
        System.out.println();

    }

    /**
     * k个一组反转链表
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode prev = hair;
        while (head != null) {
            //获取尾部节点
            ListNode tail = prev;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            //获取下一个次的节点
            ListNode next = tail.next;
            ListNode[] result = myReverse(head, tail);
            head = result[0];
            tail = result[1];
            //连接左右
            prev.next = head;
            tail.next = next;
            //移动指针位置
            prev = tail;
            head = tail.next;
        }
        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

    public ListNode inplaceReverse(ListNode head) {
        //每次只断开一个，连接一个
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseByStack(ListNode head) {
        ListNode temp = head;
        Deque<ListNode> stack = new LinkedList<ListNode>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        ListNode result = new ListNode();
        ListNode temp2 = new ListNode();
        temp2 = stack.pop();
        result.next = temp2;
        while (!stack.isEmpty()) {
            temp2.next = stack.pop();
            temp2 = temp2.next;
        }
        temp2.next = null;
        return result.next;
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
