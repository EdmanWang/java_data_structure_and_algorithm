package com.edmanwang.linkedList;

/**
 * 双向链表
 */
public class DoubleNode {

    private DoubleNode pre;

    private DoubleNode next;

    private int data;

    public DoubleNode(int data) {
        this.pre = this;
        this.next = this;
        this.data = data;
    }

    /**
     * 添加一个双向节点
     *
     * @param node
     */
    public void add(DoubleNode node) {
        // 记录当前节点的下个节点，作为新节点的下一个节点
        DoubleNode nextNext = this.next;
        //修改当前节点的下一个节点为，需要添加的节点
        this.next = node;
        // 添加节点的前驱节点是当前节点
        node.pre = this;
        // 添加节点的下一个节点是，前面记录的节点
        node.next = nextNext;
        // 记录节点的前驱节点是需要添加的节点
        nextNext.pre = node;
    }

    public int getData() {
        return this.data;
    }

    public DoubleNode getPre() {
        return this.pre;
    }

    public DoubleNode getNext() {
        return this.next;
    }
}
