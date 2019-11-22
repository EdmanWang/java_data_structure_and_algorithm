package com.edmanwang.tree.threadTree;

public class ThreadBinaryTree {

    private ThreadBinaryTreeNode root;

    // 用于存储此节点的前一个节点
    private ThreadBinaryTreeNode preNode;

    public void setRootNode(ThreadBinaryTreeNode root) {
        this.root = root;
    }

    public void addLeftNode(ThreadBinaryTreeNode node) {
        root.addLeftNode(node);
    }

    public void addRightNode(ThreadBinaryTreeNode node) {
        root.addRightNode(node);
    }

    public void middleShow(ThreadBinaryTreeNode node) {
        root.middleShow(node);
    }

    /**
     * 将这棵树装换成一个线索二叉树
     */
    public void changeThreadBinaryTree(ThreadBinaryTreeNode node) {
        if (node == null) {
            return;
        }

        // 处理左边孩子
        changeThreadBinaryTree(node.leftNode);

        // 如果发现当前节点的左边孩子为空
        if (node.leftNode == null) {
            // 设置左边孩子节点类型为前驱节点
            node.leftType = 1;
            // 设置当前节点的前驱节点
            node.leftNode = preNode;
        }

        /**
         * 这里为啥需要采用前一个节点作为参考：因为当前节点是拿不到后一个节点
         */
        if (preNode != null && preNode.rightNode == null) {
            preNode.rightType = 1;
            preNode.rightNode = node;
        }

        preNode = node;

        // 处理右边孩子
        changeThreadBinaryTree(node.rightNode);
    }

    public void threadBinaryTreeIterate() {
        ThreadBinaryTreeNode node = root;

        while (node != null) {
            while (node.leftType == 0) {
                node = node.leftNode;
            }

            System.out.println(node.value);

            while (node.rightType == 1) {
                node = node.rightNode;
                System.out.println(node.value);
            }

            node = node.rightNode;

        }
    }
}
