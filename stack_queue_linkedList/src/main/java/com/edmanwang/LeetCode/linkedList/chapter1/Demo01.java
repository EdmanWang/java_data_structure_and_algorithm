package com.edmanwang.LeetCode.chapter1;

/**
 * @Author EdmanWang
 * @create 2020/2/26 9:27
 */
public class Demo01 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 思路：从第一个节点的基础上。在跨域k个节点。并查看该节点是否为空
        ListNode node = head;
        if (node == null) {
            return null;
        }
        while (node != null) {
            ListNode tempNode = getNode(node, k);
            if (tempNode == null) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private ListNode getNode(ListNode head, int k) {
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
