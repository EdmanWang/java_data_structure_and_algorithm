package com.edmanwang.leetcode.chapter2;

/**
 * @Author EdmanWang
 * @create 2020/2/25 9:28
 */
public class Demo04 {

    public static int[] decompressRLElist(int[] nums) {
        int newLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                newLength = newLength + nums[i];
            }
        }
        int[] newArr = new int[newLength];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != 0) {
                for (int j = 0; j < nums[i - 1]; j++) {
                    newArr[index++] = nums[i];
                }
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] ints = decompressRLElist(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
