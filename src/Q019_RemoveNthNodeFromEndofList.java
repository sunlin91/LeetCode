/**
 * Created by SUN on 2017.12.13.
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Q019_RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head;
        ListNode pre=head;
        ListNode q=head;
        while (n>0&&p!=null){
            pre=p;
            p=p.next;
            n--;
        }
        if(n==0&&p==null){
            q=head.next;
            return q;
        }
        while (p!=null){
            pre=q;
            q=q.next;
            p=p.next;
        }
        if(pre!=null&&q!=null){
            pre.next=q.next;
        }
        return head;
    }
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

