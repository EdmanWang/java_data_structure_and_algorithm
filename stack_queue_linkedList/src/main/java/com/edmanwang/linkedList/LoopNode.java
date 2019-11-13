package com.edmanwang.linkedList;

public class LoopNode {

    private int data;

    private LoopNode next;

    public LoopNode(int data) {
        this.data = data;
        next = this;
    }

    /**
     * 删除指定节点中的下一个节点
     */
    public void deleteAfter() {
        // 记录当前节点的下下个节点
        LoopNode nextNextNode = this.next.next;
        this.next = nextNextNode;
    }

    public void insertAfter(LoopNode node) {
        // 保存该节点的下一个节点，作为插入节点的下一个节点
        LoopNode next = this.next;
        // 修改当前节点的下一个节点为需要添加的节点
        this.next = node;
        // 设置添加的节点的下一个节点为之前保留的一个节点
        node.next = next;
    }

    public LoopNode getNext() {
        return this.next;
    }

    /**
     * 得到节点数据
     *
     * @return
     */
    public int getData() {
        return this.data;
    }
}
