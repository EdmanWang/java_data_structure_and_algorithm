package com.edmanwang.chapter2;

import java.util.Arrays;

/**
 * 插入排序
 * 实现思路：
 * 第一个数表示就是有序的。
 * 当操作爹二个数的时候，如果发现当前数，比前面的数小，就是需要移动当前数
 * 移动当前数的事还，需要保存当前数
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 9, 1, 5, 10, 9};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int j;
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    // 移动操作，将当前数，赋值给前一个数
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }
    }
}
