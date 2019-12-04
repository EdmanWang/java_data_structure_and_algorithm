package com.edmanwang.leetcode.chapter1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Demo01 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 6, 3, 9, 0};
        int[] ints = twoSum2(nums, 8);
        System.out.println("------------华丽的分割线------------");
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        // 典型的空间换时间
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = i;
                result[1] = map.get(nums[i]);
                return result;
            }
            // 每次存放的是需要加上的目标数的数值，以及当前数字的下标
            map.put(target - nums[i], i);
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
