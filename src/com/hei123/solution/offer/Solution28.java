package com.hei123.solution.offer;

import java.util.Stack;

public class Solution28 {

    public boolean isSymmetric(TreeNode root) {
        return isSame(root, root);
    }

    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSame(left.left, right.right) && isSame(left.right, right.left);

    }

    public boolean check(TreeNode left, TreeNode right) {
        //使用栈来判断
        Stack<TreeNode> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while (!stack.isEmpty()) {
            TreeNode a = stack.pop();
            TreeNode b = stack.pop();
            if (a == null && b == null) {
                continue;
            }
            if ((a == null || b == null) || a.val != b.val) {
                return false;
            }
            stack.push(left.right);
            stack.push(right.left);

            stack.push(left.left);
            stack.push(right.right);
        }
        return true;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
