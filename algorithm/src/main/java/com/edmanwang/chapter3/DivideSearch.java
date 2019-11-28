package com.edmanwang.chapter3;

/**
 * 二分法查找数据
 */
public class DivideSearch {

    public static final int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};

    public static void main(String[] args) {
        Integer index = divideSearch(arr, 1);
        System.out.println(index);
    }

    /**
     * 实现思路：
     * 1：创建两个下标，low:表示数组最低位下标即：从0开始，hight : 表示数组最高位下标
     * 2：移动下标，如果找到目标数字，就不用遍历，直接返回。如果低位下标大于高位下标都还没找到，就说名找不着目标数
     *
     * @param arr
     * @param target
     * @return
     */
    public static Integer divideSearch(int[] arr, int target) {
        int index = -1;
        int low = 0;
        int hight = arr.length - 1;
        while (hight >= low) {
            int middle = (low + hight) / 2;
            if (arr[middle] == target) {
                index = middle;
                break;
            }
            if (arr[middle] > target) {
                hight = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return index;
    }
}
