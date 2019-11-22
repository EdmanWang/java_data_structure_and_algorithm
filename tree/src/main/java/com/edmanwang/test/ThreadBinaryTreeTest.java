package com.edmanwang.test;

import com.edmanwang.tree.threadTree.ThreadBinaryTree;
import com.edmanwang.tree.threadTree.ThreadBinaryTreeNode;

public class ThreadBinaryTreeTest {

    public static void main(String[] args) {
        ThreadBinaryTree tree = new ThreadBinaryTree();

        ThreadBinaryTreeNode root = new ThreadBinaryTreeNode('A');
        tree.setRootNode(root);

        ThreadBinaryTreeNode n1 = new ThreadBinaryTreeNode('B');
        ThreadBinaryTreeNode n2 = new ThreadBinaryTreeNode('C');

        root.addLeftNode(n1);
        root.addRightNode(n2);

        ThreadBinaryTreeNode n3 = new ThreadBinaryTreeNode('D');
        ThreadBinaryTreeNode n4 = new ThreadBinaryTreeNode('E');
        ThreadBinaryTreeNode n5 = new ThreadBinaryTreeNode('F');

        n1.addLeftNode(n3);
        n1.addRightNode(n4);
        n2.addLeftNode(n5);

        tree.middleShow(root);
        System.out.println("--------------");

        // 将这颗树转换成一个线索二叉树
        tree.changeThreadBinaryTree(root);

        ThreadBinaryTreeNode node = n4.leftNode;
        System.out.println(node.value);

        tree.threadBinaryTreeIterate();
    }
}
