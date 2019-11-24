package com.edmanwang.tree.huffmanTree.netDataCompress;

import java.util.*;

public class TestNetDataHuffmanTree {

    public static void main(String[] args) {
        String str = "can you can a can as a can canner can a can.";
        // 将字符串转换成字byte数组
        byte[] bytes = str.getBytes();

        // 统计相同节点出现的次数,并返回一个节点集合
        List<Node> nodes = getNodeCount(bytes);

        // 根据nodes 创建对用的哈夫曼树
        Node root = createHuffmanTree(nodes);
        System.out.println(root);

        // 创建对应的哈夫曼编码表
        Map<Byte, String> huffmanCodes = createHuffmanCode(root);

        System.out.println(huffmanCodes);

    }

    static StringBuilder sb = new StringBuilder();
    static Map<Byte, String> huffmanCode = new HashMap<Byte, String>();

    private static Map<Byte, String> createHuffmanCode(Node root) {
        if (root == null) {
            return null;
        }
        createHuffmanCode(root.getLeftNode(), "0", sb);
        createHuffmanCode(root.getRightNode(), "1", sb);

        return huffmanCode;
    }

    private static void createHuffmanCode(Node node, String code, StringBuilder sb) {
        StringBuilder connect = new StringBuilder(sb);
        connect.append(code);
        if (node.getValue() == null) {
            createHuffmanCode(node.getLeftNode(), "0", connect);
            createHuffmanCode(node.getRightNode(), "1", connect);
        } else {
            huffmanCode.put(node.getValue(), connect.toString());
        }
    }

    /**
     * 创建对应的哈夫曼树
     *
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            // 排序
            Collections.sort(nodes);
            Node leftNode = nodes.get(nodes.size() - 1);
            Node rightNode = nodes.get(nodes.size() - 2);

            Node parentNode = new Node(leftNode.getWeight() + rightNode.getWeight(), null);
            parentNode.setLeftNode(leftNode);
            parentNode.setRightNode(rightNode);
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parentNode);
        }
        return nodes.get(0);
    }

    // 用于统计节点出现的次数
    static Map<Byte, Integer> nodeMap = new HashMap<Byte, Integer>();

    /**
     * 得到节点出现的次数
     *
     * @param bytes
     */
    private static List<Node> getNodeCount(byte[] bytes) {
        List<Node> nodeList = new ArrayList<Node>();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            if (nodeMap.containsKey(b)) {
                int count = nodeMap.get(b) + 1;
                nodeMap.put(b, count);
            } else {
                int count = 1;
                nodeMap.put(b, count);
            }
        }

        // 遍历map,查看
        for (Map.Entry<Byte, Integer> map : nodeMap.entrySet()) {
            System.out.println(map.getKey() + ":" + map.getValue());
            nodeList.add(new Node(map.getValue(), map.getKey()));
        }
        return nodeList;
    }
}

