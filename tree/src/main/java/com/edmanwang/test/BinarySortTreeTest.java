package com.edmanwang.test;

import com.edmanwang.tree.binarySortTree.BinarySortTree;
import com.edmanwang.tree.binarySortTree.BinarySortTreeNode;

public class BinarySortTreeTest {

    public static void main(String[] args) {

        int[] arr = {7, 5, 9, 3, 6, 8, 12};

        BinarySortTree tree = new BinarySortTree();

        // 添加节点
        for (int i = 0; i < arr.length; i++) {
            tree.addNode(new BinarySortTreeNode(arr[i]));
        }

        // 中序遍历
//        tree.middleShow();
//
//        System.out.println("--------------------------");
//
//        // 查找节点
//        BalanceBinaryTreeNode node = tree.searchNode(9);
//        System.out.println(node.getParent());
//
//        System.out.println("--------------------------");

        // 删除节点
        tree.deleteNode(7);

        System.out.println("--------------delete------------");
        tree.middleShow();
    }
}
