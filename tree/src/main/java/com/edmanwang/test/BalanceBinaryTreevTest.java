package com.edmanwang.test;

import com.edmanwang.tree.balanceBinaryTree.BalanceBinaryTree;
import com.edmanwang.tree.balanceBinaryTree.BalanceBinaryTreeNode;

public class BalanceBinaryTreevTest {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {6, 5, 4,3,2};
        BalanceBinaryTree tree = new BalanceBinaryTree();

        for (int i = 0; i < arr2.length; i++) {
            tree.addNode(new BalanceBinaryTreeNode(arr2[i]));
        }

        tree.middleShow();



//        // 计算树的深度

        System.out.println("=============");
//        System.out.println(tree.root.getLeftNodeHeight());
//        System.out.println(tree.root.getRightNodeHeight());

        System.out.println(tree.root.getValue());
        System.out.println(tree.root.getLeftNode().getValue());
        System.out.println(tree.root.getRightNode().getValue());

        System.out.println("=============");
        System.out.println(tree.root.getLeftNode().getLeftNode().getValue());
    }
}
