package com.edmanwang.test;

import com.edmanwang.tree.linkedTree.BinaryTree;
import com.edmanwang.tree.linkedTree.TreeNode;

// 二叉树测试
public class LinkedBinaryTreeTest {

    public static void main(String[] args) {
        // 理解为这是一棵树
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode('A');
        // 树里面有一方法，就是设置根节点方法
        tree.setRoot(root);

        TreeNode n2 = new TreeNode('B');
        TreeNode n3 = new TreeNode('C');
        root.setLeftNode(n2);
        root.setRightNode(n3);

        n2.setLeftNode(new TreeNode('D'));
        n2.setRightNode(new TreeNode('E'));

        n3.setLeftNode(new TreeNode('F'));
        n3.setRightNode(new TreeNode('J'));

        // 先序遍历树的节点
        System.out.println("-----先序遍-----");
        tree.frontShow(root);
        System.out.println();

        // 中序遍历节点
        System.out.println("-----中序遍-----");
        tree.middleShow(root);
        System.out.println();

        // 后序遍历
        System.out.println("-----后序遍历-----");
        tree.lastShow(root);
        System.out.println();

        System.out.println("-----树中的节点查找one-----");
        TreeNode node1 = tree.nodeSearchOne('C');
        System.out.println(node1.getData());

        System.out.println("-----树中的节点查找two-----");
        TreeNode node2 = tree.nodeSearchTwo('F');
        System.out.println(node2.getData());

        System.out.println("-----树中的节点查找three-----");
        TreeNode node3 = tree.nodeSearchThree('D');
        System.out.println(node3.getData());


        System.out.println("++++++++删除节点++++++++");

        // 树节点删除
        tree.deleteNode('D');
        tree.frontShow(root);
    }
}
