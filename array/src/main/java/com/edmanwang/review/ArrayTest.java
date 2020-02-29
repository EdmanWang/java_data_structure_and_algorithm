package com.edmanwang.review;

/**
 * @Author EdmanWang
 * @create 2020/2/24 11:03
 */
public class ArrayTest {


    private int size; //数组的长度
    private int date[];
    private int index; //数组中已经放入的数据长度

    public ArrayTest(int size) {
        this.size = size;
        this.date = new int[size];
        this.index = 0;
    }

    public void print() {
        for (int i = 0; i < index; i++) {
            System.out.print(date[i] + ",");
        }
        System.out.println();
    }

    public void insert(int location, int num) {
        if (index++ < size) {
            //表示考验向数组中插入数据
            for (int i = index; i > location; i--) {
                date[i] = date[i - 1];
            }
            date[location] = num;
        }
        //数组需要扩容
    }

    public void delete(int location) {
        for (int i = location; i < index; i++) {
            date[i] = date[i + 1];
        }
        index--;
    }

    public void select(int location){
        System.out.println(date[location]);
    }

    public void update(int location, int num){
        date[location] = num;
    }


    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest(10);
        arrayTest.insert(0, 1);
        arrayTest.insert(1, 2);
        arrayTest.insert(2, 4);
        arrayTest.insert(2, 3);

        arrayTest.print();

        arrayTest.delete(2);
        arrayTest.delete(1);

        arrayTest.print();

    }
}
