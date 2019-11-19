package com.edmanwang.chapter2;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 12, 14, 16, 26};
        int[] arr = new int[]{5, 3, 2, 6, 1, 6, 7, 6, 5};
//        int[] arr = new int[]{3, 2};
        System.out.println("----------------排序前------------------");
        System.out.println(Arrays.toString(arr));
        System.out.println("----------------排序后------------------");
//        merge(arr, 0, 0, arr.length - 1);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (high > low) {
            int middle = (low + high) / 2;
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }

    public static void merge(int[] arr, int low, int middle, int high) {
        int[] tempArr = new int[high - low + 1];
        int lowIndex = low;
        int middleIndex = middle + 1;
        int tempIndex = 0;

        while (lowIndex <= middle && middleIndex <= high) {
            if (arr[lowIndex] <= arr[middleIndex]) {
                tempArr[tempIndex] = arr[lowIndex];
                lowIndex++;
                tempIndex++;
            }

            if (arr[lowIndex] > arr[middleIndex]) {
                tempArr[tempIndex] = arr[middleIndex];
                middleIndex++;
                tempIndex++;
            }
        }

        while (lowIndex <= middle) {
            tempArr[tempIndex] = arr[lowIndex];
            lowIndex++;
            tempIndex++;
        }

        while (middleIndex <= high) {
            tempArr[tempIndex] = arr[middleIndex];
            middleIndex++;
            tempIndex++;
        }

        for (int i = 0; i < tempArr.length; i++) {
            arr[i + low] = tempArr[i];
        }
    }
}
