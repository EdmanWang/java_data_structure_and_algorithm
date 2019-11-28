package com.edmanwang.hashTble;

import com.edmanwang.model.People;

/**
 * 哈希表中的哈希算法：即是哪个hashCode函数
 * 一般使用的哈希函数有
 * 1：直接选址法 例如 【直接放一个 数组 【1，2，5，9，6，3】】
 * 2：数据分析法  例如【1：身份证后四位，电话号码后四位....】 这种用的不多，一应为使用这种方法前驱需要了解数据
 * 3：平方取中  24 * 24 再取中间的那位数
 * 4：取余算法
 * 5：随即算法 不常用
 */

/**
 * 散列冲突的解决办法：
 * 1：开放地址法
 *     1:1 ：线性探测法  ---> 探测该位置的下一个位置是否存在数据，按照这个循环下去
 *    1.2 ： 二次探测法  ---> 该算法是对线性探测算法的优化，即，按照未知的饿二次方计算接下来需要探测的位置
 *    1.3：再哈希法  --- > 有多个哈希函数，当使用第一个哈希函数出现冲突的时候，就使用第二个再次计算哈希值，如此循环下去，直到数据不在冲突
 * 2：链地址法 即是： 在储存数据的地方划分一块地址用来存放下一个可能冲突的数据地址链接，如果多个冲突，则是按照这种方法一直链接下去，这也是常用的一个解决散列冲突的方法
 */
public class HashTable {

    private People[] perples;

    public HashTable(int size) {
        this.perples = new People[size];
    }

    // 需要向hash表中放入元素
    public void addElement(People people) {
        // 通过散列函数，计算得到对象需要放的位置  int index = f(n)
        int index = people.hashCode();
        perples[index] = people;
    }

    // 查看哈希table中是否存在这个元素
    public boolean query(People people) {
        return perples[people.hashCode()] == null ? false : true;
    }

    // 遍历哈希表
    public void show() {
        for (int i = 0; i < perples.length; i++) {
            System.out.println(perples[i]);
        }
    }

}
