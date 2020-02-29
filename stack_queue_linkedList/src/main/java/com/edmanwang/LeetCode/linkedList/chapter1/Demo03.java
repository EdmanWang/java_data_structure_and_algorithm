package com.edmanwang.LeetCode.chapter1;

/**
 * @Author EdmanWang
 * @create 2020/2/26 11:12
 */
public class Demo03 {

    /**
     * node表示需要删除的节点
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
