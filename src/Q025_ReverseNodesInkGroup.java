/**
 * Created by SUN on 2017.12.17.
 * Given a linked list, reverse the nodes of a linked list k at a time
 * and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes
 * in the end should remain as it is.
 * <p>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p>
 * Only constant memory is allowed.
 * <p>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 */
public class Q025_ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||head.next==null||k<=1)
            return head;
        ListNode result = new ListNode(0);
        ListNode p=head,q=result;
        while (p!=null){
            ListNode start=p,end=p;
            int i=0;
            for(;i<k;i++){
                end=p;
                p=p.next;
                if(p==null)break;
            }
            if(p==null&&i<k-1){
                q.next=start;
            }else {
                ListNode a=start,b,c=start;
                start=start.next;
                a.next=null;
                while (start!=end){
                    b=start;
                    start=start.next;
                    b.next=a;
                    a=b;
                }
                end.next=a;
                q.next=end;
                q=c;
                q.next=null;
            }
        }
        return result.next;
    }
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
