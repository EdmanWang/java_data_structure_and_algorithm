package com.edmanwang.stack;

public class Mystack {

    private int[] elements;

    public Mystack() {
        elements = new int[0];
    }

    /**
     * 在数组最后添加元素,即使入栈操作
     *
     * @param element
     */
    public void push(int element) {
        int[] newArr = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = element;
        elements = newArr;
        newArr = null;
    }

    /**
     * 弹出栈顶元素，并删除栈顶元素
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈中没有元素");
        }
        int element = elements[elements.length - 1];
        int[] newArr = new int[elements.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = elements[i];
        }
        elements = newArr;
        newArr = null;
        return element;
    }

    /**
     * 弹出栈顶元素，但是不删除栈顶元素
     *
     * @return
     */
    public int peak() {
        return elements[elements.length - 1];
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return elements.length == 0;
    }
}
