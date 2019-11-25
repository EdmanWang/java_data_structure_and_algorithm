package com.edmanwang.tree.huffmanTree.netDataCompress;

import java.util.*;

public class TestNetDataHuffmanTree {

    public static void main(String[] args) {
        String str = "can you can a can as a can canner can a can.";
        // 将字符串转换成字byte数组
        byte[] bytes = str.getBytes();

        // 将数据进行哈夫曼编码压缩
        byte[] huffmanZip = huffmanZip(bytes);

        // 进行哈夫曼解码工作 解码
        String string = huffmanDecode(huffmanZip);
        System.out.println(string);
    }


    private static String huffmanDecode(byte[] huffmanZip) {
        StringBuilder sb = new StringBuilder();
        // 遍历编码以后的byte数组
        for (int i = 0; i < huffmanZip.length; i++) {
            // 每一个元素都是一个byte
            byte b = huffmanZip[i];
            // 将byte转换成二进制的字符串
            String byteToBit = null;
            if (i == huffmanZip.length - 1) {
                byteToBit = byteToBit(false, b);
            } else {
                byteToBit = byteToBit(true, b);
            }
            sb.append(byteToBit);
        }

        Map<String, Byte> stringByteMap = new HashMap<String, Byte>();

        for (Map.Entry<Byte, String> map : huffmanCode.entrySet()) {
            stringByteMap.put(map.getValue(), map.getKey());
        }

        String result = sb.toString();
        List<Byte> list = new ArrayList<Byte>();
        for (int i = 0; i < result.length(); ) {
            int count = 1;

            boolean flag = true;
            Byte aByte = null;
            while (flag) {
                String key = result.substring(i, i + count);
                aByte = stringByteMap.get(key);
                if (aByte == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(aByte);
            i = i + count;
        }

        byte[] resultBytes = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resultBytes[i] = list.get(i);
        }
        return new String(resultBytes);
    }

    private static String byteToBit(boolean flag, byte i) {
        int temp = i;
        String string = null;
        if (flag) {
            int tempInt = temp | 256;
            string = Integer.toBinaryString(tempInt);
            return string.substring(string.length() - 8);
        } else {
            string = Integer.toBinaryString(temp);
            return string;
        }
    }

    public static byte[] huffmanZip(byte[] bytes) {
        // 统计相同节点出现的次数,并返回一个节点集合
        List<Node> nodes = getNodeCount(bytes);

        // 根据nodes 创建对用的哈夫曼树,得到根节点
        Node root = createHuffmanTree(nodes);

        // 创建对应的哈夫曼编码表
        Map<Byte, String> huffmanCodes = createHuffmanCode(root);

        // 实现字符串的编码 ,返回的是一个byte数组
        byte[] encodeByte = huffmanEncode(bytes, huffmanCodes);

        return encodeByte;
    }

    private static byte[] huffmanEncode(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(huffmanCodes.get(bytes[i]));
        }
        int length;
        if (sb.length() % 8 == 0) {
            length = sb.length() / 8;
        } else {
            length = sb.length() / 8 + 1;
        }

        byte[] by = new byte[length];
        int index = 0;
        for (int i = 0; i < sb.length(); i = i + 8) {
            String subStr;
            if (i + 8 > sb.length()) {
                subStr = sb.substring(i);
            } else {
                subStr = sb.substring(i, i + 8);
            }
            byte byt = (byte) Integer.parseInt(subStr, 2);
            by[index] = byt;
            index++;
        }
        return by;
    }

    static StringBuilder sb = new StringBuilder();
    static Map<Byte, String> huffmanCode = new HashMap<Byte, String>();

    /**
     * 得到哈夫曼编码表
     *
     * @param root
     * @return
     */
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
            // 节点排序
            Collections.sort(nodes);
            // 每次取到最后两个元素
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
            nodeList.add(new Node(map.getValue(), map.getKey()));
        }
        return nodeList;
    }
}

