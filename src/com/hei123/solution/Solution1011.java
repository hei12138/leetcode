package com.hei123.solution;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
 */
public class Solution1011 {
    public static void main(String[] args) {
        // 在这里修改用例数据
        //int[] ans = new int[]{1, 1, 2, 2, 3};
         int[] ans = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int len = subArray(ans);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int subArray(int[] ans) {
        // 在这里编辑代码
        //使用指针维护当前最后一个重复元素的位置，并移动后面的元素到前面来
        //0, 0, 1, 1, 1, 1, 2, 3, 3
        int left = 0;
        int repeatCount = 0;
        for (int right = 1; right < ans.length; right++) {
            if (ans[right] == ans[left]) {
                repeatCount++;
            } else {
                repeatCount = 0;
            }
            if (repeatCount >= 2) {
                //重复次数超过2次后，左边位置不动，右边位置++
                //right++;
            } else {
                //挪动数组元素
                ans[left+1] = ans[right];
                left++;
            }
        }
        return left + 1;
    }

}
