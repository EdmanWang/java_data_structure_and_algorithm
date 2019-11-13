package com.edmanwang.test;

import com.edmanwang.utils.MyArrayUtil;

public class MyArrayTest {

    public static void main(String[] args) {
        // 查看数组
        MyArrayUtil.showElement();
        System.out.println(MyArrayUtil.getElementSize());
        System.out.println("-------------------------------");
        // 添加元素进数组
        MyArrayUtil.addElement(56);
        MyArrayUtil.addElement(57);
        MyArrayUtil.addElement(58);
        MyArrayUtil.addElement(59);
        MyArrayUtil.showElement();
        System.out.println(MyArrayUtil.getElementSize());
        System.out.println("-------------------------------");

        MyArrayUtil.putElement(3,33);
        MyArrayUtil.showElement();
        System.out.println(MyArrayUtil.getElementSize());
        System.out.println("-------------------------------");

        // 删除数组元素
        MyArrayUtil.deleteElement(1);
        MyArrayUtil.showElement();
        System.out.println(MyArrayUtil.getElementSize());
        System.out.println("-------------------------------");

        // 更新数组元素
        MyArrayUtil.updateElement(2,100);
        MyArrayUtil.showElement();
        System.out.println(MyArrayUtil.getElementSize());
        System.out.println("-------------------------------");


    }
}
