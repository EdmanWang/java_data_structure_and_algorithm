package com.edmanwang.leetcode.chapter2;

/**
 * @Author EdmanWang
 * @create 2020/2/24 22:07
 */
public class Demo03 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i > 0; i--) {
            digits[i]++;
            if (digits[i] % 10 != 0){
                return digits;
            }
        }
        int[] newdigits = new int[digits.length + 1];
        newdigits[0] = 1;
        return newdigits;
    }

    public static void main(String[] args) {

    }
}
