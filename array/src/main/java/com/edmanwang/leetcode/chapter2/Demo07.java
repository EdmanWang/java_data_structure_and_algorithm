package com.edmanwang.leetcode.chapter2;

import java.util.Map;
import java.util.Stack;

/**
 * @Author EdmanWang
 * @create 2020/2/25 11:05
 */
public class Demo07 {

    public static ListNode reverseList1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.add(node);
            node = node.next;
        }
        ListNode newNode = new ListNode(stack.pop().val);
        while (!stack.isEmpty() ){
            newNode.next = stack.pop();
            newNode = newNode.next;
        }
        return newNode;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;

        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        ListNode listNode = reverseList(head);
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
