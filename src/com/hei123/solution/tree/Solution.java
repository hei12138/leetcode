package com.hei123.solution.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 */
class Solution {
    public static void main(String[] args) {
//        final String s = transReversePolishNotation("2+(4*3)/2");
//        System.out.println(calculate2("-2+1"));
        TreeNode.printTree(trans2tree("1-2*3"));
    }

    public static int calculate2(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (isOperator(c) || i == s.length() - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;

                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                preSign = c;
                num = 0;
            }
        }
        return stack.stream().mapToInt(e -> e).sum();
    }

    public static int calculate(String s) {
        Stack<Integer> num_stack = new Stack<>();
        Stack<Character> operate_stack = new Stack<>();
        s = "0" + s;
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (Character.isDigit(c)) {
                //把数字找完
                int num = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                num_stack.push(num);
            }
            if (isOperator(c)) {
                if (operate_stack.isEmpty() || '(' == c || priority(c) > priority(operate_stack.peek())) {
                    operate_stack.push(c);
                } else {
                    while (!operate_stack.isEmpty() && '(' != operate_stack.peek()) {
                        if (priority(c) <= priority(operate_stack.peek())) {
                            int c1 = num_stack.pop();
                            int c2 = num_stack.pop();
                            int cal = cal(c1, c2, operate_stack.pop());
                            num_stack.push(cal);
                        }
                    }
                    operate_stack.push(c);
                }
            } else if ('(' == c) {
                operate_stack.push(c);
            } else if (')' == c) {
                while ('(' != operate_stack.peek()) {
                    int c1 = num_stack.pop();
                    int c2 = num_stack.pop();
                    int cal = cal(c1, c2, operate_stack.pop());
                    num_stack.push(cal);
                }
                operate_stack.pop();
            }
        }
        while (!operate_stack.isEmpty()) {
            int c1 = num_stack.pop();
            int c2 = num_stack.pop();
            int cal = cal(c1, c2, operate_stack.pop());
            num_stack.push(cal);
        }
        return num_stack.pop();
    }

    public static int cal(int c1, int c2, char operator) {
        if ('+' == operator) {
            return c2 + c1;
        } else if ('-' == operator) {
            return c2 - c1;
        } else if ('*' == operator) {
            return c2 * c1;
        } else if ('/' == operator) {
            return c2 / c1;
        } else {
            return 0;
        }
    }

    public static int val(String express) {
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < express.length(); i++) {
            if (isOperator(express.charAt(i))) {
                Integer s1 = stack.pop();
                Integer s2 = stack.pop();
                if ('+' == express.charAt(i)) {
                    stack.push(s2 + s1);
                } else if ('-' == express.charAt(i)) {
                    stack.push(s2 - s1);
                } else if ('*' == express.charAt(i)) {
                    stack.push(s2 * s1);
                } else if ('/' == express.charAt(i)) {
                    stack.push(s2 / s1);
                }
            } else {
                stack.push(express.charAt(i) - '0');
            }
        }
        return stack.pop();
    }

    public static TreeNode trans2tree(String s) {
        final Stack<TreeNode> nodeStack = new Stack<>();
        final Stack<Character> operate_stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (Character.isDigit(c)) {
                //把数字找完
                int num = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                nodeStack.push(new TreeNode(num + ""));
            }
            if (isOperator(c)) {
                if (operate_stack.isEmpty() || '(' == c || priority(c) > priority(operate_stack.peek())) {
                    operate_stack.push(c);
                } else {
                    while (!operate_stack.isEmpty() && '(' != operate_stack.peek()) {
                        if (priority(c) <= priority(operate_stack.peek())) {
                            TreeNode node1 = nodeStack.pop();
                            TreeNode node2 = nodeStack.pop();
                            TreeNode root = new TreeNode(operate_stack + "");
                            root.left = node2;
                            root.right = node1;
                            nodeStack.push(root);
                        }
                    }
                    operate_stack.push(c);
                }
            } else if ('(' == c) {
                operate_stack.push(c);
            } else if (')' == c) {
                while ('(' != operate_stack.peek()) {
                    TreeNode node1 = nodeStack.pop();
                    TreeNode node2 = nodeStack.pop();
                    TreeNode root = new TreeNode(operate_stack + "");
                    root.left = node2;
                    root.right = node1;
                    nodeStack.push(root);
                }
                operate_stack.pop();
            }
        }
        while (!operate_stack.isEmpty()) {
            TreeNode node1 = nodeStack.pop();
            TreeNode node2 = nodeStack.pop();
            TreeNode root = new TreeNode(operate_stack.pop() + "");
            root.left = node2;
            root.right = node1;
            nodeStack.push(root);
        }
        return nodeStack.pop();
    }


    /**
     * 中缀转后缀
     *
     * @param express
     */
    public static String transReversePolishNotation(String express) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < express.length(); i++) {
            char c = express.charAt(i);
            if (Character.isDigit(c)) {
                result.append(c);
            } else if (isOperator(c)) {
                if (stack.isEmpty() || '(' == stack.peek() || priority(c) > priority(stack.peek())) {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty() && '(' != stack.peek()) {
                        if (priority(c) <= priority(stack.peek())) {
                            result.append(stack.pop());
                        }
                    }
                    stack.push(c);
                }
            } else if ('(' == c) {
                stack.push(c);
            } else if (')' == c) {
                while ('(' != stack.peek()) {
                    Character operator = stack.pop();
                    result.append(operator);
                }
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static int priority(Character c) {
        if ('*' == c || '/' == c) {
            return 1;
        } else if ('+' == c || '-' == c) {
            return 0;
        }
        return -1;
    }

    public static boolean isOperator(Character op) {
        if (op == '+' || op == '-' || op == '*' || op == '/') {
            return true;
        }
        return false;
    }



}