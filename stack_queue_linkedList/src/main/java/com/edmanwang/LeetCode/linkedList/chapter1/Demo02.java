package com.edmanwang.LeetCode.chapter1;

import java.util.Stack;

/**
 * @Author EdmanWang
 * @create 2020/2/26 9:55
 */
public class Demo02 {

    public static boolean isPalindrome1(ListNode head) {
        //1:第一次遍历栈接收数据
        Stack stack = new Stack<ListNode>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        //2:第二次遍历，栈中弹出的数据和链表中的数据要一致
        while (head != null) {
            ListNode stackNode = (ListNode) stack.pop();
            if (stackNode.val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome(ListNode head) {
        //1:采用双指针，计算出链表中的中间节点
        ListNode slow = head;
        ListNode fast = head;
        // 上面的循环结束的时候，slow节点就是链表的中间节点
        while (fast.next != null && fast.next.next != null) {
            // 慢指针一次走一步，块指针一次走两步
            slow = slow.next;
            fast = fast.next.next;
        }

        //翻转链表中slow节点后面的节点
        ListNode pre = null;
        ListNode tempNode;
        ListNode cur = slow;
        while (cur != null) {
            tempNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNode;
        }

        while (head != null && pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
