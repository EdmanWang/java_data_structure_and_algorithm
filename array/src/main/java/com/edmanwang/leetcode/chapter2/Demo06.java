package com.edmanwang.leetcode.chapter2;

/**
 * @Author EdmanWang
 * @create 2020/2/25 10:24
 */
public class Demo06 {

    public static int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int[] tempA = points[i];
            int[] tempB = points[i + 1];
            int aLength = Math.abs(tempB[0] - tempA[0]);
            int bLength = Math.abs(tempB[1] - tempA[1]);

            totalTime = (bLength >= aLength ? bLength : aLength) + totalTime;
        }
        return totalTime;
    }

    public static void main(String[] args) {
        int[][] points = {{3, 2}, {-2, 2}};
        System.out.println(minTimeToVisitAllPoints(points));
    }
}
