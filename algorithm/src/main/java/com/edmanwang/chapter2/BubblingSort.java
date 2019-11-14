package com.edmanwang.chapter2;

import java.util.Arrays;

/**
 * 冒泡排序的实现
 * 需要注意的地方
 * 1:数组个数 - 1 表示需要比较的轮数
 * 2：每一轮需要比较的次数
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 9, 1, 5, 10, 9};
        bubbling(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 2,6,9,1,2,6,9
     * 2,6,1,2,6,9,9
     * 需要比较 n-1 轮
     * 每一轮需要比较 n-1-i
     *
     * @param arr
     */
    public static void bubbling(int[] arr) {
        // 需要比较的轮数
        for (int i = 0; i < arr.length - 1; i++) {
            // 每一轮需要比较的次数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
