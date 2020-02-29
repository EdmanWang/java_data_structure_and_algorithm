package com.edmanwang.LeetCode.queue.chapter1;

/**
 * @Author EdmanWang
 * @create 2020/2/28 10:12
 */
public class Demo02 {

    /**
     * 实现的冒泡排序
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers1(int[] arr, int k) {
        int[] ret = new int[k];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 实现插入排序
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] ret = new int[k];
        for (int i = 1; i < arr.length; i++) {
            int j = 0;
            while (j <= i) {

                j++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 40, 112, 56, 5, 6, 12, 100};
        int[] numbers = getLeastNumbers(arr, 1);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
