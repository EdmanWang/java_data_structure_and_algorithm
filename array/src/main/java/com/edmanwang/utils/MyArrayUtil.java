package com.edmanwang.utils;

import java.util.Arrays;

/**
 * 面向对象数组的实现
 */
public class MyArrayUtil {

    private static Object[] elements = new Object[0];

    private static int length = 0;

    /**
     * 在数组末尾中添加一个元素
     *
     * @param obj
     */
    public static void addElement(Object obj) {
        Object[] newArr = new Object[++length];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = obj;
        elements = newArr;
        newArr = null;
    }

    /**
     * 向数组中指定位置的位置添加元素
     *
     * @param obj
     */
    public static void putElement(int index, Object obj) {
        verifyIndex(index);
        Object[] newArr = new Object[++length];
        for (int i = 0; i < elements.length; i++) {
            if (i < index) {
                newArr[i] = elements[i];
            } else {
                newArr[i + 1] = elements[i];
            }
        }
        newArr[index] = obj;
        elements = newArr;
        newArr = null;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index
     */
    public static void deleteElement(int index) {
        verifyIndex(index);
        Object[] newArr = new Object[--length];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = elements[i];
            } else {
                newArr[i] = elements[i + 1];
            }
        }
        elements = newArr;
        newArr = null;
    }

    /**
     * 跟新数组中指定位置的元素
     *
     * @param index
     * @param obj
     */
    public static void updateElement(int index, Object obj) {
        verifyIndex(index);
        elements[index] = obj;
    }

    /**
     * 查看数组元素
     */
    public static void showElement() {
        System.out.println(Arrays.toString(elements));
    }

    public static int getElementSize() {
        return length;
    }


    /**
     * 校验index
     *
     * @param index
     */
    private static void verifyIndex(int index) {
        if (index < 0 || index > length - 1) {
            throw new RuntimeException("输入的索引错误， 错误索引为" + index);
        }
    }
}
