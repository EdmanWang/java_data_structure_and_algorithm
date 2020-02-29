package com.edmanwang.LeetCode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author EdmanWang
 * @create 2020/2/27 15:40
 */
public class Demo04 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        int index = 0;
        int[] ret = new int[nums.length - k + 1];
        for (int low = 0; low < nums.length; low++) {
            if (low + k <= nums.length) {
                int[] tempNums = new int[k];
                for (int i = 0; i < k; i++) {
                    tempNums[i] = nums[low + i];
                }
                int maxNumber = getMaxNumber(tempNums);
                ret[index++] = maxNumber;
            }
        }
        return ret;
    }

    private int getMaxNumber(int[] nums) {
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > temp) {
                temp = nums[i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        Demo04 demo04 = new Demo04();
        int[] ints = demo04.maxSlidingWindow(nums, 3);
        for (int i = 0;i<ints.length;i++){
            System.out.println(ints[i]);
        }
    }
}
