package com.welph.leecode.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/06/05
 *     desc  :
 * </pre>
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 创建测试数据
     *
     * @param data [XX,XX,null,xx]
     * @return {@link TreeNode}
     */
    public static TreeNode createTestData(String data) {
        if (data.equals("[]")) return null;
        data = data.substring(1, data.length() - 1);
        String[] split = data.split(",");
        int len = split.length;
        TreeNode[] treeNodes = new TreeNode[len];
        for (int i = 0; i < len; i++) {
            if (!split[i].equals("null")) {
                treeNodes[i] = new TreeNode(Integer.valueOf(split[i]));
            }
        }
        for (int i = 0; i < len; i++) {
            if (treeNodes[i] != null) {
                int leftIndex = i * 2 + 1;
                if (leftIndex < len) {
                    treeNodes[i].left = treeNodes[leftIndex];
                }
                int rightIndex = leftIndex + 1;
                if (rightIndex < len) {
                    treeNodes[i].right = treeNodes[rightIndex];
                }
            }
        }
        return treeNodes[0];
    }

    private static final String space = "      ";

    /**
     * 竖向打印二叉树
     *
     * @param root 二叉树根节点
     */
    public static void print(TreeNode root) {
        print(root, 0);
    }

    private static void print(TreeNode node, int deep) {
        if (node == null) {
            printSpace(deep);
            System.out.println("#");
            return;
        }
        print(node.right, deep + 1);
        printSpace(deep);
        printNode(node.val);
        print(node.left, deep + 1);
    }

    private static void printSpace(int count) {
        for (int i = 0; i < count; i++) {
            System.out.printf(space);
        }
    }

    private static void printNode(int val) {
        StringBuilder res = new StringBuilder(val + "<");
        int spaceNum = space.length() - res.length();
        for (int i = 0; i < spaceNum; i++) {
            res.append(" ");
        }
        System.out.println(res);
    }

    public static void printFront(TreeNode node) {
        List<Integer> results = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        results.add(node.val);
        queue.add(node);
        TreeNode pop;
        while (queue.peek() != null) {
            pop = queue.pop();
            if (null != pop.left) {
                results.add(pop.left.val);
                queue.add(pop.left);
            } else {
                results.add(null);
            }
            if (null != pop.right) {
                results.add(pop.right.val);
                queue.add(pop.right);
            } else {
                results.add(null);
            }
        }
        System.out.println(results);
    }
}
