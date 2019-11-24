package com.edmanwang.test;

import com.edmanwang.tree.huffmanTree.HuffmanTree;
import com.edmanwang.tree.huffmanTree.HuffmanTreeNode;

/**
 * 测试哈夫曼树
 */
public class HuffmanTreeTest {

    public static void main(String[] args) {
        int[] arr = {3,6,9,15,7,23,25,48,1};
        HuffmanTree huffmanTree = new HuffmanTree();

        HuffmanTreeNode node = huffmanTree.huffmanTreeShow(arr);
        System.out.println(node);
    }
}
