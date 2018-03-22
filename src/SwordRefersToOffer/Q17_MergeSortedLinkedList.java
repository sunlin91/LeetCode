package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Q17_MergeSortedLinkedList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1==null)
            return list2;
        if (list2==null)
            return list1;
        ListNode p1= list1,p2=list2;
        ListNode newHead = new ListNode(0);
        ListNode pos = newHead;
        while (p1!=null&&p2!=null){
            if (p1.val<p2.val){
                pos.next=p1;
                pos=pos.next;
                p1=p1.next;
            }else {
                pos.next=p2;
                pos=pos.next;
                p2=p2.next;
            }
        }
        if (p1!=null){
            pos.next=p1;
        }
        if (p2!=null)
            pos.next=p2;
        return newHead.next;
    }
}