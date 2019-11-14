package com.edmanwang.chapter1;

/**
 * 斐波那契数列实现
 * 实现的思路就是，递归实现
 */
public class Fibonacci {
    /**
     * 1，1，2，3，5，8，13
     *
     * @param args
     */
    public static void main(String[] args) {
        int fibonacci = calFibonacci(8);
        System.out.println(fibonacci);
    }

    public static int calFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return calFibonacci(n - 1) + calFibonacci(n - 2);
        }
    }
}
