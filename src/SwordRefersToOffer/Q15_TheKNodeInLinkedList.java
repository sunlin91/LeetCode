package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Q15_TheKNodeInLinkedList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head==null)
            return head;
        ListNode p = head;
        while (p!=null&&k-->0){//p为null时k不需要再--，所以放在&&后面
            p=p.next;
        }
        if (k>0)
            return null;
        ListNode q = head;
        while (p!=null){
            q=q.next;
            p=p.next;
        }
        return q;
    }

//    public ListNode FindKthToTail(ListNode head,int k) {
//        if(head==null||k<=0)
//            return null;
//        int i=1;
//        ListNode p = head;
//        ListNode q = head;
//        while(i<k&&q.next!=null){
//            q=q.next;
//            i++;
//        }
//        if(i<k)
//            return null;
//        while(q.next!=null){
//            q=q.next;
//            p=p.next;
//        }
//        return p;
//    }
}
