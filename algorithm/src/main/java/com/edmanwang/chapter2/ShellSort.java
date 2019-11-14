package com.edmanwang.chapter2;

import java.util.Arrays;

/**
 * 希尔排序实现：
 * 实现的思路：
 * 与一个增量的概念。
 * 按照增量为步长，每一组显示检查插入排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 9, 1, 5, 10, 9, 22, 3, 56, 0, 1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        // 通过增量来确定需要循环的次数
        for (int d = arr.length / 2; d > 0; d /= 2) {
            // 得到数组中需要比较的数
            for (int i = d; i < arr.length; i++) {
                //这里才是真正实现每一组的快速插入排序
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
