package SwordRefersToOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SunLin on 2018.3.8
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class Q56_EntryNodeOfLoop {
    Set<ListNode> set = new HashSet<>();
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        set.clear();
        if (pHead==null)
            return null;
        ListNode pos=pHead;
        while (pHead.next!=null){
            if (!set.add(pos)){
                return pos;
            }
            pos=pos.next;
        }
        return null;
    }
}
