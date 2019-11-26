package com.edmanwang.tree.balanceBinaryTree;

/**
 * 二叉排序树实现
 */
public class BalanceBinaryTree {

    public BalanceBinaryTreeNode root;

    public void addNode(BalanceBinaryTreeNode node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    /**
     * 中序遍历
     */
    public void middleShow() {
        root.middleShow(root);
    }
}
