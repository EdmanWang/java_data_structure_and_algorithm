package com.edmanwang.chapter2;

import java.util.Arrays;

/**
 * 快速排序实现
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 9, 1, 5, 10, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (end > start) {
            // 表示数组的下标
            int low = start;
            int high = end;
            // 标识位
            int standNumber = arr[low];
            while (high > low) {
                // 玩高位
                while (high > low && standNumber <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];

                // 玩低位
                while (high > low && standNumber >= arr[low]) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = standNumber;
            // 需要进行递归处理
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }
}
