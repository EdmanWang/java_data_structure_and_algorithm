package com.edmanwang.leetcode.chapter1;

import java.util.Arrays;

public class Demo05 {

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        int i = threeSumClosest(nums, 1);
        System.out.println(i);
    }

    public static int threeSumClosest(int[] nums, int target) {

        // 入参判断
        if (nums.length < 3) {
            throw new RuntimeException("数据异常");
        }
        // 排序
        Arrays.sort(nums);

        // 默认这个数距离target最近
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int low = i + 1;
            int high = nums.length - 1;

            while (high > low) {
                int sum = nums[i] + nums[low] + nums[high];

                // 如果直接找到数据和目标数一样，直接返回
                if (sum == target) {
                    return sum;

                }

                // 每一组循环都有一个最小数
                int min = nums[i] + nums[low] + nums[low + 1];
                if (min > target) {
                    // 只有当这个数子距离目标数字更近的时候，才进行数据交换，重新设置结果
                    if (Math.abs(min - target) < Math.abs(result - target)) {
                        result = min;
                    }
                    break;
                }

                // 每一组循环都有一个最大数
                int max = nums[i] + nums[high] + nums[high - 1];
                if (max < target) {
                    if (Math.abs(max - target) < Math.abs(result - target)) {
                        result = max;
                    }
                    break;
                }
//
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    // 表示上面的三个数值的和表原来的小
                    result = sum;
                }

                if (sum > target) {
                    high--;
                    while (high > low && nums[high] == nums[high + 1]) {
                        high--;
                    }
                }

                if (sum < target) {
                    low++;
                    while (high > low && nums[low] == nums[low - 1]) {
                        low++;
                    }
                }
            }
        }
        return result;
    }
}


