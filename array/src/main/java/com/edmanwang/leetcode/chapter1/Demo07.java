package com.edmanwang.leetcode.chapter1;

// 删除排序数组中的重复项
public class Demo07 {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int duplicates = removeDuplicates(nums);
        System.out.println("--------------------------华丽的分割线----------------------");
        for (int i = 0; i < duplicates; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int indexLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 重新设置索引对应的值
            nums[indexLength] = nums[i];
            indexLength++;
        }
        return indexLength;
    }
}
