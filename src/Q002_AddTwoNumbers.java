/**
 * Created by SUN on 2017.11.16.
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Q002_AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        ListNode p1 = l1;//记录最后一个位置
        int sums;//每一位的和
        int a = 0;//是否有进位
        while (l1 != null && l2 != null) {
            sums = l1.val + l2.val + a;
            a = sums / 10;
            sums %= 10;
            l1.val = sums;
            p1 = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if ((l1 == null) && (l2 == null)) {
            if (a != 0) {
                p1.next = new ListNode(1);
            }
        }
        if (l1 != null) {
            while (a > 0 && l1 != null) {
                sums = a + l1.val;
                a = sums / 10;
                l1.val = sums % 10;
                p1 = l1;
                l1 = l1.next;
            }
            if (a != 0) {
                p1.next = new ListNode(1);
            }
        }
        if (l2 != null) {
            p1.next = l2;
            while (a > 0 && l2 != null) {
                sums = a + l2.val;
                a = sums / 10;
                l2.val = sums % 10;
                p1 = l2;
                l2 = l2.next;
            }
            if (a != 0) {
                p1.next = new ListNode(1);
            }
        }
        return head;
    }

    //官网方法
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
