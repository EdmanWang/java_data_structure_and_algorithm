package com.edmanwang.chapter2.reviewCode2;

import java.util.Arrays;

/**
 * 四种排序复习
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 6, 1, 8, 9, 20, 1, 7, 8};
        System.out.println("------------未排序之前---------------");
        System.out.println(Arrays.toString(arr));
        System.out.println("++++++++++++排序之前+++++++++++++++++");
//        bubbingSort(arr);
//        quickSort(arr, 0, arr.length - 1);
//        insertSort(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbingSort(int[] arr) {
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
     * 快速排序的思想是
     * 有一个标准数，默认是数组的第一个数，作为排序的标准数
     * 两个下标，分别是 低位数字下标，高位数字下标
     * 移动下标，交换高低位数
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (end > start) {
            int low = start;
            int high = end;
            int standNumber = arr[low];
            while (high > low) {
                // 先对高位处理
                while (high > low && standNumber <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];

                // 低位处理
                while (high > low && standNumber >= arr[low]) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = standNumber;
            // 递归处理
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }
    }

    /**
     * 快速插入排序：实现的思想
     * 已左边的第一个数，作为局部有序。
     * 一旦发现当前数字比局部有序的数组中最后一个数字小的时候，发生移动，就最后的一个数字
     * 向前移动，直到需要移动的数组比局部有序数组中的一个数字大。即：完成排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
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
     * 希尔排序实现的思想：
     * 希尔排序是在快速排序的思想上进行改进的，即 如果出现【2,3,5,6,7,8,9,1】
     * 上面这种情况下的一种排序方式
     * 希尔排序几个关键点
     * 1：步长概念，
     * 2：按照步长分组以后，需要比较的元素个数
     * 3：如果发现当前数字比分组中最近的一个元素数字小的话，就要按照快速排序的思想去实现
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        // 步长的概念
        for (int d = arr.length / 2; d > 0; d = d / 2) {
            // 按照步长分完以后，需要比较的个数
            for (int i = d; i < arr.length; i++) {
                // 如果发现当前数字小于分组中的最近的一个数字
                if (arr[i - d] > arr[i]) {
                    int temp = arr[i];
                    int j;
                    // 按照快速排序的方式进行
                    for (j = i - d; j >= 0 && temp < arr[j]; j = j - d) {
                        arr[j + d] = arr[j];
                    }
                    arr[j + d] = temp;
                }
            }
        }
    }
}
