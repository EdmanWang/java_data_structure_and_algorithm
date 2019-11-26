package com.edmanwang.tree.balanceBinaryTree;

/**
 * 二叉排序数节点类
 */
public class BalanceBinaryTreeNode {

    private Integer value;

    private BalanceBinaryTreeNode leftNode;

    private BalanceBinaryTreeNode rightNode;

    private BalanceBinaryTreeNode parent;

    public BalanceBinaryTreeNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public BalanceBinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BalanceBinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BalanceBinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BalanceBinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public BalanceBinaryTreeNode getParent() {
        return parent;
    }

    public void setParent(BalanceBinaryTreeNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "BalanceBinaryTreeNode{" + "value=" + value + " }";
    }

    public int height() {
        return Math.max(leftNode == null ? 0 : leftNode.height(), rightNode == null ? 0 : rightNode.height()) + 1;
    }

    public void addNode(BalanceBinaryTreeNode node) {
        if (node == null) {
            return;
        } else {
            if (node.value < this.value) {
                if (this.leftNode == null) {
                    this.leftNode = node;
                } else {
                    this.leftNode.addNode(node);
                }
            } else {
                if (this.rightNode == null) {
                    this.rightNode = node;
                } else {
                    this.rightNode.addNode(node);
                }
            }
        }

        // 每添加完一个节点以后，需要检查是否是平衡二叉树
        if (this.getLeftNodeHeight() - this.getRightNodeHeight() >= 2) {
            BalanceBinaryTreeNode newNode = new BalanceBinaryTreeNode(this.value);
            newNode.rightNode = rightNode;
            newNode.leftNode = leftNode.rightNode;
            value = leftNode.value;
            leftNode = leftNode.leftNode;
            rightNode = newNode;
        }
    }

    public void middleShow(BalanceBinaryTreeNode node) {
        if (node.leftNode != null) {
            node.leftNode.middleShow(node.leftNode);
        }
        System.out.println(node.value);
        if (node.rightNode != null) {
            node.rightNode.middleShow(node.rightNode);
        }
    }

    // 计算左边孩子的高度
    public int getLeftNodeHeight() {
        if (this.leftNode == null) {
            return 0;
        }
        return this.leftNode.height();
    }

    // 计算左边孩子的高度
    public int getRightNodeHeight() {
        if (this.rightNode == null) {
            return 0;
        }
        return this.rightNode.height();
    }

}
