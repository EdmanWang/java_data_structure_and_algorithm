package com.edmanwang.LeetCode.stack.chapter1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author EdmanWang
 * @create 2020/2/27 17:16
 */
public class Demo05 {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length <= 0) {
            return nums;
        }

        int index = 0;
        int[] ret = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList();

        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }

        ret[index++] = queue.peek();
        for (int i = 0; i < nums.length - k; i++) {
            // 这个nums[i] 表示将要移除的元素
            if (nums[i] == queue.peek()) {
                queue.pollFirst();
            }

            while (!queue.isEmpty() && nums[i + k] > queue.getLast()) {
                queue.removeLast();
            }
            queue.addLast(nums[i + k]);
            ret[index++] = queue.getFirst();
        }


        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1};
        Demo05 demo05 = new Demo05();
        int[] ints = demo05.maxSlidingWindow(nums, 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
