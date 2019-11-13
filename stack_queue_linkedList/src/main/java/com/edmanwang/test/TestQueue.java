package com.edmanwang.test;

import com.edmanwang.queue.MyQueue;

public class TestQueue {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        System.out.println(myQueue.isEmpty());

        myQueue.add(95);
        myQueue.add(96);
        myQueue.add(97);
        System.out.println(myQueue.size());
        myQueue.show();

        System.out.println("--------------------华丽的分割线--------------------");
        System.out.println(myQueue.remove());
        myQueue.add(100);
        System.out.println(myQueue.remove());
    }
}
