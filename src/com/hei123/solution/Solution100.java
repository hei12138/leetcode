package com.hei123.solution;

import java.util.LinkedList;

public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeDfs(p, q);
    }

    public boolean isSameTreeDfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (q == null || p == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTreeDfs(p.left, q.left) && isSameTreeDfs(p.right, q.right);
        }
    }


    public class TreeNode {
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
