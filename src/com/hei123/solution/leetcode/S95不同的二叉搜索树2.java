package com.hei123.solution.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 */
public class S95不同的二叉搜索树2 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTree(1, n);
    }

    public List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        //终止条件
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTree(start, i - 1);
            List<TreeNode> rights = generateTree(i + 1, end);
            //拼装左右节点
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    result.add(treeNode);
                }

            }
        }
        return result;
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
