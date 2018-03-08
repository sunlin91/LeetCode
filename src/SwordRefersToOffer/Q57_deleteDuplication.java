package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.8
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Q57_deleteDuplication {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {

        ListNode first = new ListNode(-1);//设置一个trick
        first.next = pHead;
        ListNode p = pHead;
        ListNode last = first;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p!= null&&p.val == val)
                    p = p.next;
                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }
    //为什么有的case明明是空的说返回null。
    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead==null||pHead.next==null)
            return pHead;
        ListNode head = new ListNode(0);
        head.next=pHead;
        ListNode pos = pHead;
        ListNode pre = head;
        while (pos.next!=null){
            if (pos.val==pos.next.val) {
                while (pos.next != null && pos.val == pos.next.val) {
                    pos = pos.next;
                }
                pos = pos.next;
                pre.next=pos;
                continue;
            }
            pre=pos;
            pos=pos.next;
        }
        return head.next;
    }
}
