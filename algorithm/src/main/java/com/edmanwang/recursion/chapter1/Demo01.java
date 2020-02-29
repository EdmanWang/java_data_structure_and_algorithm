package com.edmanwang.recursion.chapter1;

/**
 * @Author EdmanWang
 * @create 2020/2/28 20:20
 * <p>
 * 使用递归实现阶乘
 * 5 = 5 * 4 * 3 * 2 * 1；
 * <p>
 * f(n) = n*f(n-1)
 */
public class Demo01 {

    /**
     * 使用递归解决
     * @param number
     * @return
     */
    public static int fac(int number) {
        if (number == 1)
            return 1;
        return number * fac(number - 1);
    }

    /**
     * 使用非递归解决递归问题
     * @param number
     * @return
     */
    public static int notRec(int number) {
        int temp = 1;
        for (int i = 1; i <= number; i++) {
            temp = temp * i;
        }
        return temp;
    }

    /**
     * 使用尾递归解决递归问题
     * @param number
     * @param res
     * @return
     */
    public static int tailRec(int number, int res) {
        if (number == 1)
            return res;
        res = number * res;
        return tailRec(number - 1, res);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + ":" + fac(i));
        }

        System.out.println("---------------------");

        for (int i = 1; i <= 5; i++) {
            System.out.println(i + ":" + notRec(i));
        }

        System.out.println("---------------------");

        for (int i = 1; i <= 5; i++) {
            System.out.println(i + ":" + tailRec(i, 1));
        }

    }
}
