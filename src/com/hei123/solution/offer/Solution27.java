package com.hei123.solution.offer;

import java.util.Stack;

public class Solution27 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        //使用栈存储，交换每个数据的左右节点
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            //入栈
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
        }
        return root;
    }
}
