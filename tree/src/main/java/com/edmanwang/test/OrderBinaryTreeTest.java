package com.edmanwang.test;

import com.edmanwang.tree.orderTree.OrderBinaryTree;

public class OrderBinaryTreeTest {

    public static void main(String[] args) {
        char[] arr = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'J', 'H', 'I'};
        OrderBinaryTree orderBinaryTree = new OrderBinaryTree();

        orderBinaryTree.createOrderBinaryTree(arr);
        System.out.println("-------------先序遍历------------");
        orderBinaryTree.frontShow();

        System.out.println("-------------中序遍历------------");
        orderBinaryTree.middleShow();

        System.out.println("-------------后序遍历------------");
        orderBinaryTree.lastShow();


    }
}
