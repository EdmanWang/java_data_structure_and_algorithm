package com.edmanwang.utils;

/**
 * 二分法查找
 */
public class BinarySearchUtil {

    public static int binarySearch(int[] arr, int target) {
        int begin = 0;
        int end = arr.length - 1;
        int mid = (begin + end) / 2;
        int index = -1;

        while (true) {
            if (begin > end) {
                break;
            }
            if (target == arr[mid]) {
                index = mid;
                break;
            } else {
                if (target > arr[mid]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
                mid = (begin + end) / 2;
            }
        }
        return index;
    }
}
