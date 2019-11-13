package com.edmanwang.test;

import com.edmanwang.linkedList.Node;

public class TestNode {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.append(new Node(2)).append(new Node(3)).append(new Node(4));
        System.out.println(n1.getNext().getNext().getNext().getData());
        // 查看节点数据
        n1.showNode();

        // 在2节点后面添加一个节点，节点数据为100
        n1.getNext().insertAfter(new Node(100));
        n1.showNode();

        //在2节点后面删除一个节点
        n1.getNext().deleteAfter();
        n1.showNode();
    }
}
