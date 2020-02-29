package com.edmanwang.leetcode.chapter2;

/**
 * @Author EdmanWang
 * @create 2020/2/25 10:05
 */
public class Demo05 {

    public int findNumbers(int[] nums) {
        int i = 0;
        int total = 0;
        while (i < nums.length) {
            int temp = nums[i];
            String str = String.valueOf(temp);
            if (str.length() % 2 == 0) {
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
