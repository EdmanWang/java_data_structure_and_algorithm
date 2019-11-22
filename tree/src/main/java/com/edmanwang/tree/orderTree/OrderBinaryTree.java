package com.edmanwang.tree.orderTree;

public class OrderBinaryTree {

    private char[] treeArray;

    public void createOrderBinaryTree(char[] arr) {
        if (arr.length <= 0) {
            throw new RuntimeException("输入的数组长度小于0");
        }
        treeArray = arr;
    }

    /**
     * 顺序二叉树先序遍历
     * 需要了解两个概念:
     * 1:当前节点的左孩子是:   2*n+1; 其中n 表示元素在数组中的下标
     * 2：前节点的左孩子是:   2*n+2; 其中n 表示元素在数组中的下标
     * 3：当前节点的父节点是： （n-1）/2  其中n 表示元素在数组中的下标
     */
    public void frontShow() {
        frontShow(0);
    }

    public void frontShow(int index) {
        // 先遍历当前节点
        System.out.println(treeArray[index]);
        // 在递归遍历左边孩子
        if (2 * index + 1 <= treeArray.length - 1) {
            frontShow(2 * index + 1);
        }
        // 在递归遍历右边孩子
        if (2 * index + 2 <= treeArray.length - 1) {
            frontShow(2 * index + 2);
        }
    }

    /**
     * 顺序二叉树的中序遍历
     */
    public void middleShow() {
        middleShow(0);
    }

    public void middleShow(int index) {
        // 先遍历左孩子节点
        if (2 * index + 1 <= treeArray.length - 1) {
            middleShow(2 * index + 1);
        }
        //再遍历自己本身节点
        System.out.println(treeArray[index]);
        // 再遍历右边还再
        if (2 * index + 2 <= treeArray.length - 1) {
            middleShow(2 * index + 2);
        }
    }

    /**
     * 后续遍历
     */
    public void lastShow(){
        lastShow(0);
    }

    public void lastShow(int index){
        if (2 * index + 1 <= treeArray.length - 1) {
            lastShow(2 * index + 1);
        }

        if (2 * index + 2 <= treeArray.length - 1) {
            lastShow(2 * index + 2);
        }

        System.out.println(treeArray[index]);
    }
}
