package com.edmanwang.leetcode.chapter1;

import java.util.*;

public class Demo04 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int before = 0;
        Arrays.sort(nums);
        if (nums.length < 3 || nums[0] > 0) {
            return result;
        }
        if (nums[0] == nums[1] && nums[1] == nums[2] && nums[0] == 0){
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
