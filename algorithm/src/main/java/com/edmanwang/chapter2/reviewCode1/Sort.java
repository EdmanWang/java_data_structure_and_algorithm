package com.edmanwang.chapter2.reviewCode1;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 9, 1, 5, 10, 9, 22, 3, 56, 0, 1};
//        bubbingSort(arr);
//        quickSort(arr, 0, arr.length - 1);
//        insertSort(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 交换排序实现一： 冒泡排序
    public static void bubbingSort(int[] arr) {
        // 需要比较的轮数
        for (int i = 0; i < arr.length - 1; i++) {
            // 每一轮需要比较的元素个数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 交换排序实现二： 快速排序
    public static void quickSort(int[] arr, int start, int end) {
        if (end > start) {
            int low = start;
            int high = end;
            int standNumber = arr[start];
            while (high > low) {
                while (high > low && standNumber <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];

                while (high > low && standNumber >= arr[low]) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = standNumber;

            // 递归调用
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }

    // 插入排序实现二： 简单插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 发现后面的数比当前数还小，则表示需要交换位置了
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int j;
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
            }
        }
    }

    // 插入排序实现二： 希尔排序
    public static void shellSort(int[] arr) {
        // 步长控制循环的次数
        for (int d = arr.length / 2; d > 0; d = d / 2) {
            // 得到需要比较的数组数据
            for (int i = d; i < arr.length; i++) {
                //真正需要比较的组
                for (int j = i - d; j >= 0; j = j - d) {
                    if (arr[j] > arr[j + d]) {
                        int temp = arr[j + d];
                        arr[j + d] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }
}
