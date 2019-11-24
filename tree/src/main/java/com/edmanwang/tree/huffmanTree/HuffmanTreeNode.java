package com.edmanwang.tree.huffmanTree;

public class HuffmanTreeNode implements Comparable {

    private int weight;

    private HuffmanTreeNode leftNode;

    private HuffmanTreeNode rightNode;

    public int compareTo(Object o) {
        HuffmanTreeNode o1 = (HuffmanTreeNode) o;
        return o1.weight - this.weight;
    }

    public HuffmanTreeNode(int weight) {
        this.weight = weight;
    }

    public void setLeftNode(HuffmanTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(HuffmanTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "HuffmanTreeNode{" +
                "weight=" + weight +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}
