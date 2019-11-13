package com.edmanwang.test;

import com.edmanwang.utils.LineSearchUtil;

public class LineSearchTest {

    private static final int[] arr = new int[]{62, 63, 65, 12, 13};

    private static final int target = 13;

    public static void main(String[] args) {
        int index = LineSearchUtil.lineSearch(arr, target);
        System.out.println("index-----> " + index);
    }
}
