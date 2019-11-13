package com.edmanwang.utils;

/**
 * 线程查找
 */
public class LineSearchUtil {

    public static int lineSearch(int[] arr, int target) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}
