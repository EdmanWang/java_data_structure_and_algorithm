package com.edmanwang.LeetCode.queue.chapter1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author EdmanWang
 * @create 2020/2/27 18:13
 */
public class Demo01 {

    Deque<Integer> numberQueue;
    Deque<Integer> maxQueue;

    public Demo01() {
        numberQueue = new LinkedList();
        maxQueue = new LinkedList();
    }

    public int max_value() {
        return maxQueue.peek();
    }

    public void push_back(int value) {
        while (!maxQueue.isEmpty() && value >= maxQueue.getLast()) {
            maxQueue.removeLast();
        }
        maxQueue.addLast(value);
        numberQueue.addLast(value);
    }

    public int pop_front() {
        if(numberQueue.size() <=0){
            return -1;
        }
        int value = numberQueue.pop();
        if (value == maxQueue.peek()) {
            maxQueue.pop();
        }
        return value;
    }

    public static void main(String[] args) {

    }
}
