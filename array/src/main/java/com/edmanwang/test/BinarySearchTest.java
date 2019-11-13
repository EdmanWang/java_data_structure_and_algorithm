package com.edmanwang.test;

import com.edmanwang.utils.BinarySearchUtil;

public class BinarySearchTest {

    private static final int[] arr = new int[]{62, 63, 65, 95, 96, 97, 98, 100};

    private static final int target = 98;

    public static void main(String[] args) {
        int index = BinarySearchUtil.binarySearch(arr, target);
        System.out.println("index-----> " + index);
    }
}
