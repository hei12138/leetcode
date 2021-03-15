package com.hei123.solution.tree;

/**
 * @author lishencai lisc@yealink.com
 * @date 2021/3/12
 * @since 1.0.0
 */
public class Solution2 {
    static int pos=0;

    public static void main(String... args) {
        trans2Tree("12##3##");
    }

    public static boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){
                slots--;
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                slots++; // slots = slots - 1 + 2
            }
        }
        return slots == 0;
    }

    //前序遍历转二叉树
    public static TreeNode trans2Tree(String express) {
        final TreeNode tree = createTree(express);
        TreeNode.printTree(tree);
        return tree;
    }

    public static TreeNode createTree(String s) {
        if (pos >= s.length() || s.charAt(pos) == '#') {
            pos++;
            return null;
        }
        //父节点
        char c = s.charAt(pos);
        TreeNode treeNode = new TreeNode(c + "");
        pos++;
        //左树
        treeNode.left = createTree(s);
        //右数
        treeNode.right = createTree(s);
        return treeNode;
    }
}
