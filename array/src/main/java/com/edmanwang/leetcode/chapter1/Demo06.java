package com.edmanwang.leetcode.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//计算四数之和
public class Demo06 { // {-3,-1,0,2,4,5};  {-2, -1, 0, 0, 1, 2}  {-3, -2, -1, 0, 0, 1, 2, 3} {-4, 0, 0, 1, 1, 5, 5, 5}

    public static void main(String[] args) {
        int[] nums = {-4, -1, -1, 0, 1, 2};
        List<List<Integer>> fourSum = fourSum(nums, -1);
        System.out.println(fourSum.toString());
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 4) {
            return result;
        }
        int minSum = nums[0] + nums[1] + nums[2] + nums[3];
        int maxSum = nums[nums.length - 4] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];
        if (target > maxSum || minSum > target) {
            return result;
        }
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int tempTarget = target - nums[i];
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int low = j + 1;
                int high = length - 1;

                while (high > low) {
                    int sum = nums[j] + nums[low] + nums[high];
                    if (sum == tempTarget) {
                        List<Integer> tempResult = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
                        result.add(tempResult);
                        while (high > low && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (high > low && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    }
                    if (sum > tempTarget) {
                        high--;
                        while (high > low && nums[high] == nums[high + 1]) {
                            high--;
                        }
                    }
                    if (tempTarget > sum) {
                        low++;
                        while (high > low && nums[low] == nums[low - 1]) {
                            low++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
