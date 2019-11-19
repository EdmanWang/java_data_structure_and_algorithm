package com.edmanwang.tree;

//二叉树对象
public class BinaryTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public void frontShow(TreeNode root) {
        root.frontShow(root);
    }

    public void middleShow(TreeNode root) {
        root.middleShow(root);
    }

    public void lastShow(TreeNode root) {
        root.lastShow(root);
    }

    // 先序查找
    public TreeNode nodeSearchOne(char n3) {
        return root.nodeSearchOne(n3);
    }

    public TreeNode nodeSearchTwo(char c) {
        return root.nodeSearchTwo(c);
    }

    public TreeNode nodeSearchThree(char c) {
        return root.nodeSearchThree(c);
    }
}
