/**
 * Created by SUN on 2017.12.14.
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes
 * of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class Q021_MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0),q=head;
        while (l1!=null&&l2!=null){
            if(l1.val>l2.val){
                q.next=l2;
                q=q.next;
                l2=l2.next;
            }else {
                q.next=l1;
                q=q.next;
                l1=l1.next;
            }
        }
        if(l1!=null)
            q.next=l1;
        if(l2!=null)
            q.next=l2;
        head=head.next;
        return head;
    }
}
