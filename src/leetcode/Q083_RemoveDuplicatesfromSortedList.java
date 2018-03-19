package leetcode;

/**
 * Created by SunLin on 2018.3.19
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class Q083_RemoveDuplicatesfromSortedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null)
            return head;
        int val=head.val;
        ListNode q = head,p=head.next;
        q.next=null;
        while (p!=null){
            if (val==p.val){
                p=p.next;
            }else {
                val=p.val;
                q.next=p;
                q=p;
                p=p.next;
                q.next=null;
            }
        }
        return head;
    }
}
