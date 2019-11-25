package com.edmanwang.tree.huffmanTree.fileHuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHuffmanTree {

    public static void main(String[] args) {

        String wgx = "wgx";
        byte[] bytes = wgx.getBytes();
        // 哈夫曼编码实现
        byte[] zipBytes = zip(bytes);
        // 哈夫曼解码实现
        byte[] unZipBytes = unZip(zipBytes);

    }

    private static byte[] unZip(byte[] zipBytes) {
        StringBuilder sb = new StringBuilder();
        // 将编码后的byte转换成编码前的字符串
        for (int i = 0; i < zipBytes.length; i++) {
            byte zipByte = zipBytes[i];
            String str = Integer.toBinaryString(zipByte);
            String toBit = null;
            if (i == zipBytes.length - 1) {
                toBit = byteToBit(false, zipByte);
            } else {
                toBit = byteToBit(true, zipByte);
            }
            sb.append(toBit);
        }
        System.out.println("解码后 " + sb.toString());
        // 将字符串按照编码表解码

        return null;
    }

    private static String byteToBit(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    /**
     * 哈夫曼实现压缩方法具体实现
     *
     * @return
     */
    public static byte[] zip(byte[] bytes) {

        // 1: 需要将byte数组中出现的每一个byte进行统计，计算每一个元素出现的频次，并将每一个元素当做一个节点看待，将他们创建成一个树节点
        List<TreeNode> nodeList = getTreeNode(bytes);

        // 将节点集合按照哈夫曼思想去创建一棵哈夫曼数
        TreeNode node = createHuffmanTree(nodeList);

        // 创建对应的哈夫曼编码表
        Map<Byte, String> huffmanCode = createHuffmanCode(node);

//        for (Map.Entry<Byte, String> map : huffmanCode.entrySet()){
//            System.out.println(map.getKey() + ":" + map.getValue());
//        }

        // 将原byte数组进行哈夫曼编码
        byte[] encodeBytes = huffmanEncode(bytes, huffmanCode);

//        System.out.println(bytes.length);
//        System.out.println(encodeBytes.length);
        return encodeBytes;
    }

    private static byte[] huffmanEncode(byte[] bytes, Map<Byte, String> huffmanCode) {

        StringBuilder encodeStr = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];

            encodeStr.append(huffmanCode.get(b));
        }
        // 编码后的编码字符串
        System.out.println("编码后 " + encodeStr.toString());

        int length;
        if (encodeStr.length() % 8 == 0) {
            length = encodeStr.length() / 8;
        } else {
            length = encodeStr.length() / 8 + 1;
        }

        byte[] encodeBytes = new byte[length];
        Integer index = 0;
        for (int i = 0; i < encodeStr.length(); i += 8) {
            String s;
            if (i + 8 > encodeStr.length()) {
                s = encodeStr.substring(i);
            } else {
                s = encodeStr.substring(i, i + 8);
            }
            byte byt = (byte) Integer.parseInt(s, 2);
            encodeBytes[index] = byt;
            index++;
        }
        return encodeBytes;
    }


    static Map<Byte, String> huffmanCode = new HashMap<Byte, String>();

    static StringBuilder connect = new StringBuilder();

    private static Map<Byte, String> createHuffmanCode(TreeNode node) {
        if (node == null) {
            throw new RuntimeException("哈夫曼树异常......");
        }
        createHuffmanCode(node.getLeftNode(), "0", connect);
        createHuffmanCode(node.getRightNode(), "1", connect);
        return huffmanCode;
    }

    private static void createHuffmanCode(TreeNode node, String code, StringBuilder connect) {
        StringBuilder sb = new StringBuilder(connect);
        sb.append(code);
        if (node.getValue() == null) {
            createHuffmanCode(node.getLeftNode(), "0", sb);
            createHuffmanCode(node.getRightNode(), "1", sb);
        } else {
            huffmanCode.put(node.getValue(), sb.toString());
        }
    }

    private static TreeNode createHuffmanTree(List<TreeNode> nodeList) {
        while (nodeList.size() > 1) {
            Collections.sort(nodeList);
            TreeNode leftNode = nodeList.get(nodeList.size() - 1);
            TreeNode rightNode = nodeList.get(nodeList.size() - 2);
            TreeNode parent = new TreeNode(leftNode.getWeight() + rightNode.getWeight(), null);
            parent.setLeftNode(leftNode);
            parent.setRightNode(rightNode);
            nodeList.remove(leftNode);
            nodeList.remove(rightNode);
            nodeList.add(parent);
        }
        return nodeList.get(0);
    }

    private static List<TreeNode> getTreeNode(byte[] bytes) {
        Map<Byte, Integer> nodeCountMap = new HashMap<Byte, Integer>();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            if (nodeCountMap.containsKey(b)) {
                Integer count = nodeCountMap.get(b);
                count = count + 1;
                nodeCountMap.put(b, count);
            } else {
                Integer count = 1;
                nodeCountMap.put(b, count);
            }
        }

        List<TreeNode> result = new ArrayList<TreeNode>();
        for (Map.Entry<Byte, Integer> map : nodeCountMap.entrySet()) {
            TreeNode node = new TreeNode(map.getValue(), map.getKey());
            result.add(node);
        }
        return result;
    }
}
