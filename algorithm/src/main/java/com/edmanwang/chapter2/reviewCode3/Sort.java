package com.edmanwang.chapter2.reviewCode3;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 6, 1, 6, 7, 6, 5};
        System.out.println("----------------排序前------------------");
        System.out.println(Arrays.toString(arr));
        System.out.println("----------------排序后------------------");
//        bubbingSort(arr);
//        quickSort(arr, 0, arr.length - 1);
//        insertSort(arr);
//        shellSort(arr);
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序的实现的思路
     * 1：需要确定比较的轮数
     * 2：需要确定每一轮需要比较的次数
     *
     * @param arr
     */
    private static void bubbingSort(int[] arr) {
        // 需要比较的轮数
        for (int i = 0; i < arr.length - 1; i++) {
            // 每一轮需要比较的次数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 快速排序的实现思路
     * 1：找到一个标准数，默认是数组中的第一位
     * 2：接着就是先从高位开始遍历，直到找到一位比标准数小的数，就低位数和高位数交换
     * 3：从低位开始，做的事，和2步骤一样，只是相反的实现
     * 4：最后递归实现
     *
     * @param arr
     * @param start
     * @param end
     */
    private static void quickSort(int[] arr, int start, int end) {
        if (end > start) {
            int low = start;
            int high = end;
            int standNumber = arr[start];
            while (high > low) {
                // 从高位开始判断
                while (high > low && standNumber <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                // 从低位开始判断
                while (high > low && standNumber >= arr[low]) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = standNumber;

            // 递归实现
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }

    /**
     * 插入排序的实现思路
     * 1：默认当前数组中的第一个元素是有序的
     * 2：从数组中第二个元素开始做操作，如果发现遍历到的当前数，比前面有序数组中的最后一位小的时候
     * 3:移动后面有序数组中的元素
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
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

    /**
     * 希尔排序实现的思路：
     * 1:目的是缩小增量
     * 2：实现步骤
     * 2.1：有组的概念
     * 2.2：分组后，需要比较的数量
     * 2.3：按照快速排序实现
     *
     * @param arr
     */
    private static void shellSort(int[] arr) {
        for (int d = arr.length / 2; d > 0; d = d / 2) {
            for (int i = d; i < arr.length; i++) {
                if (arr[i - d] > arr[i]) {
                    int temp = arr[i];
                    int j;
                    for (j = i - d; j >= 0 && temp < arr[j]; j = j - d) {
                        arr[j + d] = arr[j];
                    }
                    arr[j + d] = temp;
                }
            }
        }
    }

    /**
     * 选择排序实现思路
     * 1：默认当前数位最小数
     * 2：比较后才交换两个数
     *
     * @param arr
     */
    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] >= arr[j]) {
                    // 记录最小数的下标
                    minIndex = j;
                }
            }
            // 比较完才去交换两个数
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
