package com.edmanwang.test;

import com.edmanwang.linkedList.DoubleNode;

public class TestDoubleNode {

    public static void main(String[] args) {
        DoubleNode n1 = new DoubleNode(1);
        DoubleNode n2 = new DoubleNode(2);
        DoubleNode n3 = new DoubleNode(3);
        DoubleNode n4 = new DoubleNode(4);

        n1.add(n2);
        n2.add(n3);
        n3.add(n4);

        System.out.println(n4.getPre().getData());
        System.out.println(n4.getData());
        System.out.println(n4.getNext().getData());
    }
}
