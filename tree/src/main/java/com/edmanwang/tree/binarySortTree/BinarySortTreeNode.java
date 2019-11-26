package com.edmanwang.tree.binarySortTree;

/**
 * 二叉排序数节点类
 */
public class BinarySortTreeNode {

    private Integer value;

    private BinarySortTreeNode leftNode;

    private BinarySortTreeNode rightNode;

    private BinarySortTreeNode parent;

    public BinarySortTreeNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public BinarySortTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinarySortTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinarySortTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinarySortTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public BinarySortTreeNode getParent() {
        return parent;
    }

    public void setParent(BinarySortTreeNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "BalanceBinaryTreeNode{" + "value=" + value + " }";
    }

    public void addNode(BinarySortTreeNode node) {
        if (node == null) {
            return;
        } else {
            if (node.value < this.value) {
                if (this.leftNode == null) {
                    this.leftNode = node;
                    // 设置节点的父节点
                    node.parent = this;
                } else {
                    this.leftNode.addNode(node);
                }
            } else {
                if (this.rightNode == null) {
                    this.rightNode = node;
                    // 设置节点的父节点
                    node.parent = this;
                } else {
                    this.rightNode.addNode(node);
                }
            }
        }
    }

    public void middleShow(BinarySortTreeNode node) {
        if (node.leftNode != null) {
            node.leftNode.middleShow(node.leftNode);
        }
        System.out.println(node.value);
        if (node.rightNode != null) {
            node.rightNode.middleShow(node.rightNode);
        }
    }

    public BinarySortTreeNode searchNode(int value) {
        BinarySortTreeNode target = null;
        if (value == this.value) {
            return this;
        }
        if (this.value > value) {
            if (this.leftNode != null) {
                target = this.leftNode.searchNode(value);
            }
        } else {
            if (this.rightNode != null) {
                target = this.rightNode.searchNode(value);
            }
        }
        return target;
    }

    public void deleteNode(int value) {
        BinarySortTreeNode node = searchNode(value);
        // 1:删除的是叶子节点，即：没有孩子节点
        if (node.rightNode == null && node.leftNode == null) {
            BinarySortTreeNode parent = node.parent;
            if (parent.leftNode.value == value) {
                parent.leftNode = null;
            } else {
                parent.rightNode = null;
            }
            return;
        }

        // 3:删除的借点有两个孩子节点
        if (node.leftNode != null && node.rightNode != null) {
            BinarySortTreeNode rightNode = node.rightNode;
            int deleteMinValue = deleteMin(rightNode);
            node.value = deleteMinValue;
        } else {
            // 2:删除的借点有一个孩子节点，但是不知道是走孩子，还是右边孩子
            if (node.leftNode != null) {
                // 表示左边孩子不为null
                BinarySortTreeNode childNode = node.leftNode;
                node.value = childNode.value;
                node.leftNode = null;
            } else {
                // 表示右边孩子不为null
                BinarySortTreeNode childNode = node.rightNode;
                node.value = childNode.value;
                node.rightNode = null;
            }
        }
    }

    private int deleteMin(BinarySortTreeNode node) {
        BinarySortTreeNode target = node;
        // 遍历找到需要删除的最小的节点，并返回该对应的值
        while (target.leftNode != null) {
            target = target.leftNode;
        }
        /**
         * 这里是有两种情况需要考虑，
         * 1：如果该节点已经没有节点了，则是直接删除该节点
         * 2：如果该节点还有右孩子，则是需要删除该节点，并找到该节点最小的节点进行补上
         */
        deleteNode(target.value);
        return target.value;
    }
}
