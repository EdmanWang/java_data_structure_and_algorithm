package com.edmanwang.sort;

import java.util.Arrays;

/**
 * @Author EdmanWang
 * @create 2020/2/29 14:50
 * <p>
 * 实现插入排序
 */
public class InsertSort {

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 需要比较的数据
            int data = nums[i];
            // 得到数据需要插入的地方
            int j = i - 1;
            for (; j >= 0; j--) {
                if (data <= nums[j]) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = data;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 9, 1, 5, 10, 9, 22, 3, 56, 0, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
