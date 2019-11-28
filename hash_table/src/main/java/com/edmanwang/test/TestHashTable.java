package com.edmanwang.test;

import com.edmanwang.hashTble.HashTable;
import com.edmanwang.model.People;

public class TestHashTable {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(20);

        People people = new People("wgx_test", 18);

        // 添加元素
        hashTable.addElement(new People("wgx", 25));
        hashTable.addElement(new People("qaz", 12));
        hashTable.addElement(new People("edmanwang", 19));
        hashTable.addElement(people);

        // 遍历
//        hashTable.show();

        // 查找元素
        boolean query = hashTable.query(new People("qaz", 12));
        System.out.println(query);
    }
}
