package com.edmanwang.recursion.chapter1;

/**
 * @Author EdmanWang
 * @create 2020/2/29 8:30
 * <p>
 * 算法思维解决斐波那契数列问题
 */
public class Demo02 {

    static int[] cache;

    public static int fab(int n) {
        if (n <= 2)
            return 1;
        return fab(n - 1) + fab(n - 2);
    }

    public static int notRec(int n) {
        if (n <= 2)
            return 1;
        int a = 1; // 上一次的值
        int b = 1; // 当前的值
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

    public static int notRec2(int n) {
        if (n <= 2) {
            return 1;
        }

        if (cache[n] != 0) {
            return cache[n];
        }
        int res = notRec2(n - 1) + notRec2(n - 2);
        cache[n] = res;
        return res;
    }

    public static int tailRec(int n, int beforeBefore, int before) {
        if (n <= 2)
            return before;
        return tailRec(n - 1, before, beforeBefore + before);
    }


    public static void main(String[] args) {
        for (int i = 1; i <= 45; i++) {
            long start = System.currentTimeMillis();
            System.out.println(fab(i) + " : " +
                    String.valueOf(System.currentTimeMillis() - start) + "ms");
        }

        System.out.println("-------------");


        for (int i = 1; i <= 45; i++) {
            cache = new int[i + 1];
            long start = System.currentTimeMillis();
            System.out.println(notRec2(i) + " : " +
                    String.valueOf(System.currentTimeMillis() - start) + "ms");
        }

        for (int i = 1; i <= 45; i++) {
            long start = System.currentTimeMillis();
            System.out.println(notRec(i) + " : " +
                    String.valueOf(System.currentTimeMillis() - start) + "ms");
        }

        for (int i = 1; i <= 45; i++) {
            long start = System.currentTimeMillis();
            System.out.println(tailRec(i, 1, 1) + " : " +
                    String.valueOf(System.currentTimeMillis() - start) + "ms");
        }
    }
}
