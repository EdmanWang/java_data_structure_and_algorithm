package com.edmanwang.leetcode.chapter2;

/**
 * @Author EdmanWang
 * @create 2020/2/24 21:18
 */
public class Demo02 {

    public int searchInsert(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            } else {
                if (nums[i] >= target) {
                    count++;
                    if (count == 1) {
                        return i;
                    }
                }
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {

    }
}
