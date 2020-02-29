package com.edmanwang.LeetCode.chapter1;

/**
 * @Author EdmanWang
 * @create 2020/2/26 17:49
 */
public class Demo08 {

    public ListNode deleteNode(ListNode head, int val) {

        if (head.val == val) {
            head = head.next;
            return head;
        }

        ListNode ret = head;
        ListNode cur = head;
        ListNode lastCur = head;

        while (cur != null){
            if (cur.val == val){
                lastCur.next = cur.next;
                break;
            }
            lastCur = cur;
            cur = cur.next;
        }
        return ret;
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
