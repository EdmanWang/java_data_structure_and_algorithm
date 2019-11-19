package com.edmanwang.tree;

// 树是由树节点创建的
public class TreeNode {

    private TreeNode leftNode;

    private char data;

    private TreeNode rightNode;

    public TreeNode(char data) {
        this.data = data;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public char getData() {
        return data;
    }

    public void frontShow(TreeNode root) {
        System.out.print(root.data + " ");
        // 处理节点的左孩子
        if (root.leftNode != null) {
            frontShow(root.leftNode);
        }
        // 处理节点的右孩子
        if (root.rightNode != null) {
            frontShow(root.rightNode);
        }
    }

    public void middleShow(TreeNode root) {
        if (root.leftNode != null) {
            middleShow(root.leftNode);
        }
        System.out.print(root.data + " ");

        if (root.rightNode != null) {
            middleShow(root.rightNode);
        }
    }

    public void lastShow(TreeNode root) {
        if (root.leftNode != null) {
            lastShow(root.leftNode);
        }
        if (root.rightNode != null) {
            lastShow(root.rightNode);
        }
        System.out.print(root.data + " ");
    }

    public TreeNode nodeSearchOne(char n3) {
        TreeNode target = null;
        if (this.data == n3) {
            return this;
        } else {
            if (this.leftNode != null) {
                target = this.leftNode.nodeSearchOne(n3);
            }
            if (target != null) {
                return target;
            }
            if (this.rightNode != null) {
                target = this.rightNode.nodeSearchOne(n3);
            }
        }
        return target;
    }

    public TreeNode nodeSearchTwo(char c) {
        TreeNode target = null;
        if (this.leftNode != null) {
            target = this.leftNode.nodeSearchTwo(c);
        }
        if (this.data == c) {
            return this;
        }
        if (target != null) {
            return target;
        }
        if (this.rightNode != null) {
            target = this.rightNode.nodeSearchTwo(c);
        }
        return target;
    }

    public TreeNode nodeSearchThree(char c) {
        TreeNode target = null;
        if (this.rightNode != null) {
            target = this.rightNode.nodeSearchThree(c);
        }
        if (this.getData() == c) {
            return this;
        }
        if (target != null) {
            return target;
        }
        if (this.leftNode != null) {
            target = this.leftNode.nodeSearchThree(c);
        }
        return target;
    }


    @Override
    public String toString() {
        return "TreeNode{" +
                ", data=" + data +
                '}';
    }
}
