package SwordRefersToOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by SunLin on 2018.3.22
 * 题目描述
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class Q05_PrintLinkedListFromBegin2End {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        Stack<Integer> s = new Stack();
        while (listNode != null) {
            s.push(listNode.val);
            listNode = listNode.next;
        }
        while (!s.empty()) {
            list.add(s.pop());
        }
        return list;
    }
}
