package com.edmanwang.leetcode.chapter1;

import java.util.*;

public class Demo04 {

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 1, 2};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 首先先排序
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] > 0) {
            return result;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            // 优化代码，如果发现当前数大于0，则不需要进行下面的操作的。
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                // 如果当前数字和前一个数字相同，则可能会出现结果集相同，所以这时候需要去重
                continue;
            }

            int low = i + 1;
            int high = nums.length - 1;

            while (high > low) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));

                    while (high > low && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (high > low && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    high--;
                    low++;
                } else if (sum > 0) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSumOne(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int before = 0;
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] > 0) {
            return result;
        }
        if (nums[0] == nums[1] && nums[1] == nums[2] && nums[0] == 0) {
            List<Integer> tempResult = new ArrayList<>();
            tempResult.add(0);
            tempResult.add(0);
            tempResult.add(0);
            result.add(tempResult);
            return result;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0) {
                before = nums[i - 1];
            }
            int twoSum = 0 - nums[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (before == nums[j]) {
                    continue;
                }
                if (map.containsKey(nums[j])) {
                    List<Integer> tempResult = new ArrayList<>();
                    tempResult.add(nums[i]);
                    tempResult.add(map.get(nums[j]));
                    tempResult.add(nums[j]);
                    result.add(tempResult);
                }
                map.put(twoSum - nums[j], nums[j]);
            }

        }
        return result;
    }
}
