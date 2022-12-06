package com.hei123.solution.array.solution108;


public class Solution108 {

    public static void main(String[] args) {
        int[] ints = {-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(ints);
        System.out.println(treeNode);
    }


    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        //取根节点
        int size = nums.length;
        int i = size / 2;
        int root = nums[i];
        TreeNode treeNode = new TreeNode(root);

        //构建左子树
        int[] leftNums = new int[i];
        int[] rightNums = new int[size - i - 1];
        System.arraycopy(nums, 0, leftNums, 0, i);
        System.arraycopy(nums, i + 1, rightNums, 0, size - i - 1);
        treeNode.left = sortedArrayToBST(leftNums);
        treeNode.right = sortedArrayToBST(rightNums);
        return treeNode;
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



