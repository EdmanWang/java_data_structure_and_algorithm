package com.edmanwang.chapter2;

import java.util.Arrays;

/**
 * 选择排序实现
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 6, 1, 8, 9, 20, 1};
        System.out.println("------------未排序之前---------------");
        System.out.println(Arrays.toString(arr));
        System.out.println("++++++++++++排序之前+++++++++++++++++");
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] <= arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
