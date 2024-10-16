package com.hei123.solution.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值
 */
public class S239滑动窗口最大值 {

    public static void main(String[] args) {
        S239滑动窗口最大值 S239滑动窗口最大值 = new S239滑动窗口最大值();
        int[] ints = {1,3,-1,-3,5,3,6,7};
        int[] ints1 = S239滑动窗口最大值.maxSlidingWindow(ints, 3);
    }

    /**
     * 维护了一个双端队列，值为当前窗口可以看到的 index, 队列第一个元素是最大值，凡是值比最大值小，且index也比此index小的全部丢弃
     * 每次遍历时 进入一个元素，按照 上述规则从队列不算抽出元素，同时，如果队列左侧的元素超出窗口了，也抽出来
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
