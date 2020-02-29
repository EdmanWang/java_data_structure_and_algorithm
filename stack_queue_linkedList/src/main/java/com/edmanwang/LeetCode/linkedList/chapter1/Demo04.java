package com.edmanwang.LeetCode.linkedList.chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author EdmanWang
 * @create 2020/2/26 11:14
 */
public class Demo04 {

    public static ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        List listNodes = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            if (!listNodes.contains(node.val)) {
                listNodes.add(node.val);
            }
            node = node.next;
        }

        ListNode addNode = head;
        ListNode pre = addNode;
        for (int i = 1; i < listNodes.size(); i++) {
            addNode.next = new ListNode((Integer) listNodes.get(i));
            addNode = addNode.next;

        }
        return pre;
    }

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second;
        while (first != null) {
            ListNode cur = first;
            second = first.next;
            while (second != null) {
                if (second.val == first.val) {
                    cur.next = second.next;
                } else {
                    cur = cur.next;
                }
                second = second.next;
            }
            first = first.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        System.out.println(removeDuplicateNodes(head));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
