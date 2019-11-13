package com.edmanwang.test;

import com.edmanwang.stack.Mystack;

public class TestStack {

    public static void main(String[] args) {
        Mystack mystack = new Mystack();

        System.out.println(mystack.isEmpty());
        mystack.push(95);
        mystack.push(96);
        mystack.push(97);
        mystack.push(98);

        System.out.println(mystack.isEmpty());

        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.isEmpty());

        System.out.println(mystack.peak());
        System.out.println(mystack.peak());
        System.out.println(mystack.peak());
    }
}
