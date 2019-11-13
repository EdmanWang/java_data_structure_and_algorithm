package com.edmanwang.queue;

public class MyQueue {

    private int[] elements;

    public MyQueue() {
        elements = new int[0];
    }

    /**
     * 向队列中添加元素,即：是入队操作
     *
     * @param element
     */
    public void add(int element) {
        int[] newArr = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = element;
        elements = newArr;
        newArr = null;
    }

    /**
     * 移除队列第一个元素
     *
     * @return
     */
    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int element = elements[0];
        int[] newArr = new int[elements.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = elements[i + 1];
        }
        elements = newArr;
        newArr = null;
        return element;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return elements.length == 0;
    }

    /**
     * 得到队列的长度
     *
     * @return
     */
    public int size() {
        return elements.length;
    }

    public void show() {
        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }
}
