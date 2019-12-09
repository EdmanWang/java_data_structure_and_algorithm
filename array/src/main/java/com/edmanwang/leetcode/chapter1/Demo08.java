package com.edmanwang.leetcode.chapter1;

public class Demo08 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int removeElement = removeElement(nums, 3);
        for (int i = 0; i < removeElement; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp == val) {
                continue;
            }
            nums[index] = temp;
            index++;
        }
        return index;
    }
}
