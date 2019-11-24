package com.edmanwang.tree.huffmanTree.netDataCompress;

public class Node implements Comparable {
    // 节点的权重
    private int weight;

    private Node leftNode;

    private Node rightNode;

    // 节点存的字节
    private Byte value;

    public Node(int weight, Byte value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Byte getValue() {
        return value;
    }

    public void setValue(Byte value) {
        this.value = value;
    }

    public int compareTo(Object o) {
        Node o1 = (Node) o;
        return o1.weight - this.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + weight +
                '}';
    }
}
