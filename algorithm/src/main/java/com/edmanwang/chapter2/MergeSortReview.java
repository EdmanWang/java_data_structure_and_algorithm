package com.edmanwang.chapter2;

import java.util.Arrays;

/**
 * @Author EdmanWang
 * @create 2020/2/28 19:27
 * <p>
 * 实现归并排序
 */
public class MergeSortReview {

    public static void mergeSort(int[] nums, int start, int end) {
        int mid = (end - start) / 2;
        int[] ret = new int[nums.length];
        int low = start;
        int height = mid;
        int index = 0;
        while (low <= mid && height <= end) {
            int lowValue = nums[low];
            int heightValue = nums[height];
            if (lowValue < heightValue) {
                ret[index] = lowValue;
                index++;
                low++;
            } else if (lowValue > heightValue) {
                ret[index] = heightValue;
                index++;
                height++;
            } else {
                ret[index] = lowValue;
                index++;
                ret[index] = heightValue;
                index++;
                height++;
                low++;
            }
        }

        while (low <= mid) {
            ret[index] = nums[low];
            index++;
            low++;
        }

        while (height <= end) {
            ret[index] = nums[height];
            index++;
            height++;
        }

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, end);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 9, 1, 5, 10, 9};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
