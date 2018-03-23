package SwordRefersToOffer;

/**
 * Created by SunLin on 2018.3.23
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Q26_CopyComplexLinkedList {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static void main(String[] args){
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
        n1.next=n2;n2.next=n3;n3.next=n4;
        n1.random=n3;n2.random=n4;n3.random=n2;n4.random=n1;
        Clone(n1);

    }

    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead==null)
            return null;
        //第一步，复制节点在原节点的后面。
        RandomListNode p=pHead;
        while (p!=null){
            RandomListNode node = new RandomListNode(p.label);
            node.next=p.next;
            p.next=node;
            p=node.next;
        }
        //第二步，复制原节点的random值，指向下一个节点
        p=pHead;
        while (p!=null){
            if (p.random!=null){
                p.next.random=p.random.next;
            }
            p=p.next.next;
        }
        //第三步，分离原链表和新链表
        int i=1;
        p=pHead.next;
        RandomListNode pre = pHead;pre.next=null;
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode q = newHead;
        while (p!=null){
            if(i%2==1){
                q.next=p;
                p=p.next;
                q=q.next;
                q.next=null;
            }else {
                pre.next=p;
                p=p.next;
                pre=pre.next;
                pre.next=null;
            }
            i++;
        }
        return newHead.next;
    }
}

//    public RandomListNode Clone(RandomListNode pHead)
//    {
//        if (pHead==null){
//            return null;
//        }
//        RandomListNode head = new RandomListNode(pHead.label);
//        RandomListNode p = head;
//        RandomListNode q = pHead.next;
//        while(q!=null){
//            RandomListNode node = new RandomListNode(q.label);
//            p.next=node;
//            p=p.next;
//            q=q.next;
//        }
//        p = head;
//        q = pHead;
//        while(q!=null){
//            RandomListNode p1=head;
//            RandomListNode pos=pHead;
//            if(q.random==null){
//                q=q.next;
//                p=p.next;
//                continue;
//            }
//            while(pos!=null&&pos!=q.random){
//                pos=pos.next;
//                p1=p1.next;
//            }
//            p.random=p1;
//            p=p.next;
//            q=q.next;
//        }
//        return head;
//    }
