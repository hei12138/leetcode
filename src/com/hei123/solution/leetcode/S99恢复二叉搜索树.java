package com.hei123.solution.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class S99恢复二叉搜索树 {
    public void recoverTree(TreeNode root) {
        //中序遍历
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(1);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
    }

    public void inorderAndRecover(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pred = root;
        TreeNode cur = root;
        ArrayList<Integer> res = new ArrayList<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek();
                res.add(cur.val);
                stack.pop();
                cur = cur.right;
            }

        }
    }

    /**
     *
     * @param root
     */
    public void inorder2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode x = null, y = null, pred = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = root;
            result.add(root.val);
            root = root.right;
        }
        swap(x, y);
    }

    public void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
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



