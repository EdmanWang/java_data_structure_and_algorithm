package com.edmanwang.chapter1;

/**
 * 汉诺塔问题实现
 * 实现的思路：
 * 将上面的n-1个盘子看成一个整体，借助剩余的一个盘子移动
 * 将最后一个盘子，直接移动到目标柱子上
 */
public class Hanoi {

    public static void main(String[] args) {
        showStep(3, 'A', 'B', 'C');
    }

    /**
     * @param n    需要移动的盘子数量
     * @param from 开始的柱子
     * @param in   中间的柱子
     * @param to   目标柱子
     */
    public static void showStep(int n, char from, char in, char to) {
        if (n == 1) {
            System.out.println("将第" + n + "盘子从" + from + "移动到" + to);
        } else {
            showStep(n - 1, from, to, in);
            System.out.println("将第" + n + "盘子从" + from + "移动到" + to);
            showStep(n - 1, in, from, to);
        }
    }
}
