package com.edmanwang.LeetCode.stack;

import java.util.Stack;

/**
 * @Author EdmanWang
 * @create 2020/2/27 9:33
 */
public class Demo01 {

    Stack<Integer> firstStack;
    Stack<Integer> secondStack;

    public Demo01() {
        firstStack = new Stack<>();
        secondStack = new Stack<>();
    }

    public void appendTail(int value) {
        firstStack.push(value);
    }

    public int deleteHead() {
        //将第一个栈中的元素移动到第二个栈到
        if (firstStack.isEmpty() && secondStack.isEmpty()) {
            return -1;
        }

        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }
        return secondStack.pop();
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        System.out.println(demo01.deleteHead());
        demo01.appendTail(5);
        demo01.appendTail(2);
        System.out.println(demo01.deleteHead());
        System.out.println(demo01.deleteHead());
    }
}
