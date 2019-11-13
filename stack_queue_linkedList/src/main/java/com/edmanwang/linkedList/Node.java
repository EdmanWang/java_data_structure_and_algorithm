package com.edmanwang.linkedList;

public class Node {

    private int data;

    private Node next;

    public Node(int data) {
        this.data = data;
    }

    /**
     * 追加节点
     *
     * @param node
     * @return
     */
    public Node append(Node node) {
        Node currentNode = this;
        while (true) {
            // 表示当前节点是最后一个节点
            if (currentNode.next == null) {
                break;
            }
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        return this;
    }

    /**
     * 删除指定节点中的下一个节点
     */
    public void deleteAfter() {
        // 记录当前节点的下下个节点
        Node nextNextNode = this.next.next;
        this.next = nextNextNode;
    }

    public void insertAfter(Node node) {
        // 保存该节点的下一个节点，作为插入节点的下一个节点
        Node next = this.next;
        // 修改当前节点的下一个节点为需要添加的节点
        this.next = node;
        // 设置添加的节点的下一个节点为之前保留的一个节点
        node.next = next;
    }

    public void showNode() {
        Node currentNode = this;
        while (!(currentNode.next == null)) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.getData());
    }

    /**
     * 判断当前节点是否是最后一个节点
     *
     * @return
     */
    public boolean isLast() {
        return this.next == null;
    }

    /**
     * 获取下一个节点对象
     *
     * @return
     */
    public Node getNext() {
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
