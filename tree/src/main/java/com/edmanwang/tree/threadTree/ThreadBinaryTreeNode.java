package com.edmanwang.tree.threadTree;

public class ThreadBinaryTreeNode {

    // 表示节点的双亲节点
    private ThreadBinaryTreeNode parent;

    // 表示该节点的左孩子节点
    public ThreadBinaryTreeNode leftNode;

    // 表示该节点的右孩子节点
    public ThreadBinaryTreeNode rightNode;

    // 表示该节点存的值
    public char value;

    // 表示左边孩子节点存储的类型，0表示存的是左孩子节点，1表示存储的是前驱节点
    public int leftType;

    // 表示右边孩子节点存储的类型，0表示存的是右孩子节点，1表示存储的是后继节点
    public int rightType;

    public ThreadBinaryTreeNode(char value) {
        this.value = value;
    }

    public void addLeftNode(ThreadBinaryTreeNode node) {
        this.leftNode = node;
        node.parent = this;
    }

    public void addRightNode(ThreadBinaryTreeNode node) {
        this.rightNode = node;
        node.parent = this;
    }

    public void middleShow(ThreadBinaryTreeNode node) {
        if (node.leftNode != null) {
            middleShow(node.leftNode);
        }
        System.out.println(node.value);
        if (node.rightNode != null) {
            middleShow(node.rightNode);
        }
    }
}
