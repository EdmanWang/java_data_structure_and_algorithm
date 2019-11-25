package com.edmanwang.tree.huffmanTree.fileHuffmanTree;

public class TreeNode implements Comparable {

    private int weight;

    private Byte value;

    private TreeNode leftNode;

    private TreeNode rightNode;

    public TreeNode(int weight, Byte value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Byte getValue() {
        return value;
    }

    public void setValue(Byte value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int compareTo(Object o) {
        TreeNode o1 = (TreeNode) o;
        return o1.weight - this.weight;
    }

    @Override
    public String toString() {
        return "TreeNode{" + "weight=" + weight + ", value=" + value + ", leftNode=" + leftNode + ", rightNode=" + rightNode + '}';
    }
}
