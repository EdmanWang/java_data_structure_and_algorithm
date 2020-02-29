package com.edmanwang.LeetCode.linkedList.chapter1;

/**
 * @Author EdmanWang
 * @create 2020/2/26 16:07
 */
public class Demo06 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null && headB == null){
            return null;
        }

        ListNode reverseA = reverse(headA);
        ListNode reverseB = reverse(headB);

        ListNode ret = null;
        while (reverseA != null || reverseB != null){
            if (reverseA.val == reverseB.val){
                ret = reverseA;
                reverseA = reverseA.next;
                reverseB = reverseB.next;
            }else {
                return ret;
            }
        }
        return null;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode tempNode;
        ListNode cur = head;
        while (cur != null) {
            tempNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNode;
        }
        return pre;
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
