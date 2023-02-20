package com.hei123.solution.tree;

import java.util.LinkedList;

/**
 * @author lishencai hei12138@outlook.com
 * @date 2021/3/12
 * @since 1.0.0
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public String val;

    public TreeNode(String val) {
        this.left = null;
        this.right = null;
        this.val = val;
    }

    /*
     * 分行从上到下打印二叉树
     */
    // 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层
    // 打印到一行。
    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null;
        int pCount = 0;      //当前层结点数目
        int nextCount = 1;   //下一层结点数目
        while (!queue.isEmpty()) {
            pCount = nextCount;
            nextCount = 0;
            //打印当前层数字，并计算下一层结点数目
            for (int i = 1; i <= pCount; i++) {
                node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextCount++;
                }
            }
            System.out.println();
        }
    }
}
