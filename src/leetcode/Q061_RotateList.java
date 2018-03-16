package leetcode;

/**
 * Created by SunLin on 2018.3.16
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4->5->NULL and k = 2,
 * <p>
 * return 4->5->1->2->3->NULL.
 */
public class Q061_RotateList {
    public static void main(String[] a){
        ListNode l = new ListNode(1);
        l.next=new ListNode(2);
        Q061_RotateList q = new Q061_RotateList();
        q.rotateRight(l,3);
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null)
            return head;
        int len = 0;
        ListNode p = head;
        while (p!=null){
            p=p.next;
            len++;
        }
        k=k%len;
        if (k==0)return head;
        p=head;
        for (int i=0;i<k;i++){
            p=p.next;
        }
        ListNode q =head;
        while (p.next!=null){
            q=q.next;p=p.next;
        }
        ListNode newHead = q.next;
        q.next=null;
        p.next=head;
        return newHead;
    }
}
