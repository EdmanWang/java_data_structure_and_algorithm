package com.edmanwang.LeetCode.linkedList.chapter1;

/**
 * @Author EdmanWang
 * @create 2020/2/26 14:30
 */
public class Demo05 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode node = new ListNode(-1);
        ListNode ret = node;
        int upValue = 0;
        while (l1 != null || l2 != null) {
            int v1 = 0, v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
            }
            if (l2 == null) {
                v2 = l2.val;
            }
            int addValue = v1 + v2 + upValue;
            upValue = addValue / 10;
            node.next = new ListNode(addValue % 10);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (upValue != 0) {
            node.next = new ListNode(upValue);
        }
        return ret.next;
    }

//    private ListNode reverse(ListNode head) {
//        ListNode pre = null;
//        ListNode tempNode;
//        ListNode cur = head;
//        while (cur != null) {
//            tempNode = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = tempNode;
//        }
//        return pre;
//    }

    private int calNodeLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void main(String[] args) {
        Demo05 demo05 = new Demo05();
        ListNode aNode = new ListNode(2);
        aNode.next = new ListNode(5);

        ListNode bNode = new ListNode(2);
        bNode.next = new ListNode(6);
        ListNode node = demo05.addTwoNumbers(aNode, bNode);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
