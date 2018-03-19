package leetcode;

/**
 * Created by SunLin on 2018.3.19
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p>
 * return 1->4->3->2->5->NULL.
 * <p>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class Q092_ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] a){
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
//        l.next.next.next = new ListNode(4);
//        l.next.next.next.next = new ListNode(5);
        reverseBetween(l,1,3);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        ListNode newHead = new ListNode(0);
        newHead.next=head;
        ListNode p=newHead,q=newHead,pre=newHead,tmp;
        for (int i=0;i<=n;i++){
            if (i<m){
                pre=p;
                p=p.next;
                q=q.next;
            }else if(i==m){
                q=q.next;
            }
            else if (i>m&&i<=n){
                tmp=q;
                q=q.next;
                tmp.next=p;
                p=tmp;
            }
        }
        tmp=pre.next;
        pre.next=p;
        tmp.next=q;
        return newHead.next;
    }
}
