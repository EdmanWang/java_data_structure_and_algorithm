package com.edmanwang.sort;

import java.util.Arrays;

/**
 * @Author EdmanWang
 * @create 2020/2/29 15:29
 * <p>
 * 实现归并排序
 */
public class MergerSort {

    public static void mergerSort(int[] nums, int left, int right) {
        if (right > left) {
            int mid = (left + right) / 2;
            mergerSort(nums, left, mid);
            mergerSort(nums, mid + 1, right);
            merger(nums, left, mid, right);
        }
    }

    public static void merger(int[] nums, int left, int mid, int right) {
        int point1 = left;
        int point2 = mid + 1;
        int ioc = left;
        int[] temp = new int[nums.length];
        while (point1 <= mid && point2 <= right) {
            if (nums[point1] < nums[point2]) {
                temp[ioc++] = nums[point1++];
            } else {
                temp[ioc++] = nums[point2++];
            }
        }

        while (point1 <= mid) {
            temp[ioc++] = nums[point1++];
        }

        while (point2 <= right) {
            temp[ioc++] = nums[point2++];
        }

        for (int i = left; i <= right; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 9, 1, 5, 10, 9, 22, 3, 56, 0, 1};
        mergerSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
