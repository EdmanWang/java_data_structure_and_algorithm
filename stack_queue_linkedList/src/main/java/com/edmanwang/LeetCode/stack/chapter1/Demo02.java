package com.edmanwang.LeetCode.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author EdmanWang
 * @create 2020/2/27 10:32
 */
public class Demo02 {

    /**
     * Initialize your data structure here.
     */

    Stack<Integer> firstStack;
    Stack<Integer> secondStack;

    public Demo02() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        firstStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return secondStack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
