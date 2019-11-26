package com.edmanwang.tree.binarySortTree;

/**
 * 二叉排序树实现
 */
public class BinarySortTree {

    private BinarySortTreeNode root;

    public void addNode(BinarySortTreeNode node) {
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

    public BinarySortTreeNode searchNode(int value) {
        if (root.getValue() == value){
            return root;
        }else {
            return root.searchNode(value);
        }
    }

    /**
     * 删除节点分为三种情况
     * 1：删除的是叶子节点
     * 2：删除只有一个子节点的节点
     * 3：删除有两个节点的借点
     * @param value
     */
    public void deleteNode(int value) {
        root.deleteNode(value);
    }
}
