package com.edmanwang.leetcode.chapter1;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * 归并排序实现，寻找两个有序数组中的中位数
 */
public class Demo02 {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        double v = findMedianSortedArrays(nums1, nums2);
        System.out.println(v);

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] tempArr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, tempArr, 0, nums1.length);
        System.arraycopy(nums2, 0, tempArr, nums1.length, nums2.length);

        for (int i : tempArr) {
            System.out.println(i);
        }

        // 实现归并排序
        int[] ints = mergeSort(tempArr, 0, nums1.length - 1, tempArr.length - 1);

        double result = 0.0d;
        //设置保留位数
        DecimalFormat df = new DecimalFormat("0.00");

        if (ints.length % 2 == 0) {
            int sum = ints[ints.length / 2 - 1] + ints[ints.length / 2];
            String format = df.format((float) sum / 2);
            return Double.valueOf(format);

        } else {
            result = ints[ints.length / 2];
        }

        return result;
    }

    public static int[] mergeSort(int[] arr, int low, int middle, int hight) {
        int[] temp = new int[hight - low + 1];
        int tempIndex = 0;

        int tempMiddle = middle + 1;

        while (low <= middle && tempMiddle <= hight) {
            if (arr[tempMiddle] >= arr[low]) {
                temp[tempIndex] = arr[low];
                tempIndex++;
                low++;
            }

            if (arr[low] >= arr[tempMiddle]) {
                temp[tempIndex] = arr[tempMiddle];
                tempIndex++;
                tempMiddle++;
            }
        }

        while (low <= middle) {
            temp[tempIndex] = arr[low];
            tempIndex++;
            low++;
        }

        while (tempMiddle <= hight) {
            temp[tempIndex] = arr[tempMiddle];
            tempIndex++;
            tempMiddle++;
        }
        return temp;
    }
}
