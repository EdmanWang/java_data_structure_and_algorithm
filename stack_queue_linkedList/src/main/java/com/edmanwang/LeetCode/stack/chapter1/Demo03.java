package com.edmanwang.LeetCode.stack.chapter1;

import java.util.Stack;

/**
 * @Author EdmanWang
 * @create 2020/2/27 11:09
 */
public class Demo03 {

    // 这个栈用来存储入栈数据
    Stack<Integer> numberStack;
    // 这个栈用来存储最小值
    Stack<Integer> minStack;

    public Demo03() {
        numberStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (numberStack.isEmpty()) {
            minStack.push(x);
        }

        if (x <= minStack.peek()) {
            minStack.push(x);
        }
        numberStack.push(x);
    }

    public void pop() {
        // 如果弹出的栈元素和维护最小值的栈顶元素相同，则也需要将维护最小值的栈顶元素弹出
        Integer pop = numberStack.pop();
        if (pop.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
         return numberStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {

    }
}
