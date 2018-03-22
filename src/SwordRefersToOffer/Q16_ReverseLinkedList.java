package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class Q16_ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode p =head.next;
        ListNode pre = head;
        pre.next=null;
        while (p!=null){
            ListNode tmp = p;
            p=p.next;
            tmp.next=pre;
            pre=tmp;
        }
        return pre;
    }
}
