package com.edmanwang.leetcode.chapter1;

public class Demo03 {
    public static void main(String[] args) {
        int[] height = {2, 3, 4, 5, 18, 17, 6};
        int maxArea = maxAreaOne(height);
        System.out.println(maxArea);

        Integer integer = maxAreaTwo(height);
        System.out.println(integer);
    }

    public static int maxAreaOne(int[] height) {
        int width;
        int high;
        int area = -1;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                width = j - i;
                high = Math.min(height[i], height[j]);
                area = width * high > area ? width * high : area;
            }
        }
        return area;
    }

    /**
     * 双指针法
     *
     * @param height
     * @return
     */
    public static Integer maxAreaTwo(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int area = -1;

        while (high > low) {
            int width = high - low;
            int minHeight = Math.min(height[low], height[high]);
            if (height[low] <= height[high]) {
                low++;
            } else {
                high--;
            }
            area = width * minHeight > area ? width * minHeight : area;
        }
        return area;
    }
}
