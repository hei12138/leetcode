package com.hei123.solution.offer;

public class Solution26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B==null) {
            return false;
        }
        boolean b = recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        return b;
    }

    public boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
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
