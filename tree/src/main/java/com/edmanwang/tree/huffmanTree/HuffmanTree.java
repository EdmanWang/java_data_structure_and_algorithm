package com.edmanwang.tree.huffmanTree;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树实现  网络 数据 压缩 network data compress
 */
public class HuffmanTree {

    /**
     * 哈夫曼树实现的思路
     *
     * @param arr
     */
    public HuffmanTreeNode huffmanTreeShow(int[] arr) {
        // 1:将数组中的每一个元素看待成一个树，只是这棵树只有一个节点,放入到一个集合中
        List<HuffmanTreeNode> nodes = new ArrayList<HuffmanTreeNode>();
        for (int i = 0; i < arr.length; i++) {
            HuffmanTreeNode node = new HuffmanTreeNode(arr[i]);
            nodes.add(node);
        }

        while (nodes.size() > 1) {
            // 2:对集合中的数节点元素按照降序进行排序
            Collections.sort(nodes);
            // 3:每一次取集合中最后一个元素和倒数第二个元素
            HuffmanTreeNode leftNode = nodes.get(nodes.size() - 1);
            HuffmanTreeNode rightNode = nodes.get(nodes.size() - 2);
            // 4：将取出的两个元素拼接成一个新的元素，放入集合中
            HuffmanTreeNode parent = new HuffmanTreeNode(leftNode.getWeight() + rightNode.getWeight());
            parent.setLeftNode(leftNode);
            parent.setRightNode(rightNode);
            nodes.add(parent);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 5:再次对集合进行排序
            // 6:直到集合中就剩最后一个元素
        }
        return nodes.get(0);
    }
}
