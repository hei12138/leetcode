package com.hei123.solution.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class S98验证二叉搜索树 {
    public static void main(String[] args) {
        S98验证二叉搜索树 s98验证二叉搜索树 = new S98验证二叉搜索树();
        s98验证二叉搜索树.isValidBST(new TreeNode(1));
    }

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public boolean validateBSTUseRecur(TreeNode cur, int lower, int upper) {
        if (cur == null) {
            return true;
        }
        if (cur.val <= lower || cur.val >= upper) {
            return false;
        }
        return validateBSTUseRecur(cur.left, lower, cur.val)
                && validateBSTUseRecur(cur.right, cur.val, upper);
    }

    public boolean validateBSTUseInorder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pred = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null) {
                if (pred.val >= root.val) {
                    return false;
                }
            }
            pred = root;
            root = root.right;
        }
        return true;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
