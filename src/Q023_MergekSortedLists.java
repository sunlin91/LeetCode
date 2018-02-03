import java.util.*;

/**
 * Created by SUN on 2017.12.15.
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 */
public class Q023_MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0){
            return null;
        }
        ListNode head = new ListNode(0),q;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            q=lists[i];
            while (q!=null){
                result.add(q.val);
                q=q.next;
            }
        }
        Object[] r = result.toArray();
        Arrays.sort(r);
        q=head;
        for(int i=0;i<r.length;i++) {
            q.next=new ListNode((Integer) r[i]);
            q=q.next;
        }
        return head.next;
    }

    //超时？通过129/130，逐一比较的思想，为毛超时，哪里写错了？有空再看看
//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode result = new ListNode(0);
//        ListNode result_p=result;
//        if(lists==null||lists.length==0)
//            return result.next;
//        int n=lists.length;
//        ListNode[] pos = new ListNode[lists.length];
//        for(int i=0;i<lists.length;i++){
//            pos[i]=lists[i];
//        }
//        Set<Integer> set = new HashSet<>();
//        while (n>0) {
//            int curmin=0,curpos=0;
//            for(int i=0;i<lists.length;i++) {
//                if(pos[i]==null) continue;
//                curmin = pos[i].val;
//                curpos = i;
//                break;
//            }
//            for (int i = 0; i < lists.length; i++) {
//                if(set.contains(i))
//                    continue;
//                if (pos[i] == null) {
//                    n--;
//                    set.add(i);
//                    if(n==0) return result.next;
//                    continue;
//                }
//                if (pos[i].val<curmin){
//                    curmin=pos[i].val;
//                    curpos=i;
//                }
//            }
//            result_p.next=pos[curpos];
//            result_p=result_p.next;
//            pos[curpos]=pos[curpos].next;
//        }
//
//        return result.next;
//    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
