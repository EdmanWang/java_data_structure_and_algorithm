package com.edmanwang.sort;

import java.util.Arrays;

/**
 * @Author EdmanWang
 * @create 2020/2/29 15:00
 * <p>
 * 实现shell排序
 */
public class ShellSort {

    public static void sort(int[] nums) {
        //1:add 记录的是一个增量
        int add = nums.length / 2;
        while (add >= 1) {
            // 2:按照增量分组
            for (int i = 0; i < nums.length; i += add) {
                // insertValue 表示需要操作的数据
                int insertValue = nums[i];
                int j = i - add;
                // 3:移动已排好序的数据
                for (; j >= 0; j -= add) {
                    if (nums[j] >= insertValue) {
                        nums[j + add] = nums[j];
                    } else {
                        break;
                    }
                }
                nums[j + add] = insertValue;
            }
            // 修改增量
            add = add / 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 9, 1, 5, 10, 9, 22, 3, 56, 0, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
