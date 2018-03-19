package leetcode;

/**
 * Created by SunLin on 2018.3.19
 * Given a linked list and a value x, partition it such that all nodes
 * less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */
public class Q086_PartitionList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head==null)
            return head;
        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;
        ListNode q = head;
        ListNode p = head;
        if (head.val<x){
            while (p!=null&&p.val<x){
                q=p;
                p=p.next;
            }
            q.next=null;
            pre.next=head;
            pre=q;
            head=p;
            q=head;
        }
        while (p!=null){
            if (p.val<x){
                q.next = p.next;
                pre.next=p;
                pre=p;
                pre.next=null;
                p=q.next;
            }else {
                q=p;
                p=p.next;
            }
        }
        pre.next=head;
        return newHead.next;
    }
}
