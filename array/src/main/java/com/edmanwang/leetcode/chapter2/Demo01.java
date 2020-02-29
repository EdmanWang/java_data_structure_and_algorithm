package com.edmanwang.leetcode.chapter2;

/**
 * @Author EdmanWang
 * @create 2020/2/24 16:26
 */
public class Demo01 {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (j > i) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, 5, 4, 3, 1};
        Demo01 demo01 = new Demo01();

        demo01.nextPermutation(nums);

        for (int i : nums) {
            System.out.println(nums[i]);
        }
    }
}
