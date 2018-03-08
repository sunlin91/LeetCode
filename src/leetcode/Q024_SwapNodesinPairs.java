package leetcode;

import javax.sound.sampled.Line;

/**
 * Created by SUN on 2017.12.17.
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Your algorithm should use only constant space.
 * You may not modify the values in the list, only nodes itself can be changed.
 */
public class Q024_SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode result=new ListNode(0);
        ListNode p=head,q=result,tmp;
        while (p!=null&&p.next!=null){
            tmp=p.next.next;
            q.next=p.next;
            p.next.next=p;
//            p.next=null;
            q=p;
            p=tmp;
        }
        q.next=p;
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
