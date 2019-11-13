package com.edmanwang.test;

import com.edmanwang.linkedList.LoopNode;

public class TestLoopNode {

    public static void main(String[] args) {
        LoopNode n1 = new LoopNode(1);
        LoopNode n2 = new LoopNode(2);
        LoopNode n3 = new LoopNode(3);
        LoopNode n4 = new LoopNode(4);
        LoopNode n5 = new LoopNode(5);

        n1.insertAfter(n2);
        n2.insertAfter(n3);
//        n3.insertAfter(n4);
//        n4.insertAfter(n5);
        System.out.println(n1.getNext().getData());
        System.out.println(n2.getNext().getData());
        System.out.println(n3.getNext().getData());
        System.out.println(n4.getNext().getData());
        System.out.println(n5.getNext().getData());
    }
}
