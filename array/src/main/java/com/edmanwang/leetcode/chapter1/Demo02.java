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
        int[] nums2 = {2};
        double v = findMedianSortedArrays(nums1, nums2);
        System.out.println(v);

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        return (find(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2 + 1) / 2) + find(nums1, 0, len1 - 1, nums2, 0, len2 - 1, (len1 + len2) / 2 + 1)) * 0.5;

    }

    private static int find(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int cnt) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //确保nums1是短的
        if (len1 > len2) {
            return find(nums2, start2, end2, nums1, start1, end1, cnt);
        }
        //如果len1已经为空，直接从nums2找
        if (len1 == 0) {
            return nums2[start2 + cnt - 1];
        }
        //找第1个数，比较nums1[0]和nums2[0]谁更小即可
        if (cnt == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        //因为nums1比较短，因此取位置时要考虑实际长度
        int pos1 = start1 + Math.min(cnt / 2, len1) - 1;
        int pos2 = start2 + cnt / 2 - 1;
        if (nums1[pos1] > nums2[pos2]) {
            return find(nums1, start1, end1, nums2, pos2 + 1, end2, cnt - cnt / 2);
        } else {
            return find(nums1, pos1 + 1, end1, nums2, start2, end2, cnt - Math.min(cnt / 2, len1));
        }
    }

    /**
     * 使用游标方式解决问题。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArraysTwo(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int cursor1 = 0;
        int cursor2 = 0;

        int[] totalArrays = new int[length1 + length2];
        int totalCursor = 0;
        while (cursor1 != length1 || cursor2 != length2) {
            if (cursor1 == length1) {
                totalArrays[totalCursor++] = nums2[cursor2];
                cursor2++;
                continue;
            }
            if (cursor2 == length2) {
                totalArrays[totalCursor++] = nums1[cursor1];
                cursor1++;
                continue;
            }

            if (nums1[cursor1] > nums2[cursor2]) {
                totalArrays[totalCursor++] = nums2[cursor2];
                cursor2++;
            } else if (nums1[cursor1] < nums2[cursor2]) {
                totalArrays[totalCursor++] = nums1[cursor1];
                cursor1++;
            } else {
                totalArrays[totalCursor++] = nums1[cursor1];
                totalArrays[totalCursor++] = nums2[cursor2];
                cursor1++;
                cursor2++;
            }
        }

        int index = totalArrays.length % 2;
        if (index == 1) {
            return totalArrays[totalArrays.length / 2];
        } else {
            return (totalArrays[totalArrays.length / 2 - 1] + totalArrays[totalArrays.length / 2]) / 2.0;
        }
    }

    public static double findMedianSortedArraysOne(int[] nums1, int[] nums2) {
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
